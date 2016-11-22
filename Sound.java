import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Darren Moriarty on 17/11/2016.
 */
public class Sound  implements LineListener{

    public static Mixer mixer;
    public static Clip clip;

    public Sound(String path){
        try{
            URL soundURL = getClass().getResource(path);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
            AudioFormat format = audioInputStream.getFormat();


            Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();

            mixer = AudioSystem.getMixer(mixInfos[0]);

            DataLine.Info dataInfo = new DataLine.Info(Clip.class, format);

            clip = (Clip)mixer.getLine(dataInfo);

            clip.open(audioInputStream);

            clip.addLineListener(this);


        }catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void update(LineEvent event) {
        if (event.getType().equals(LineEvent.Type.STOP)){
            clip.setFramePosition(1);
        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
        clip.setFramePosition(1);
    }

    public boolean isPlayer(){
        return clip.isRunning();
    }
}
