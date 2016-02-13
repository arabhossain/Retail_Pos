/*
    Software Engineer
    ---------------------------------------
    Md. Arab Hossain
    Email: arabhossain317@diu.edu.bd
           green.arab1995@gmail.com
    Mobile: +8801827-464330
            +8801737-331037
    Daffodil International University(Student)
 */
package Sound;


/**
 *
 * @author Loser
 */
public abstract class Audio_Player {

    /**
     *
     * @param FileName
     */
    protected static void play(String FileName){
         if(!AppConfig.Settings.Mute){
             java.io.File f = new java.io.File("./src/wavs/"+FileName+".wav");
               try {
                        java.io.InputStream input_as_audio=new java.io.FileInputStream(f);
                        sun.audio.AudioStream play_audio=new sun.audio.AudioStream(input_as_audio);
                        sun.audio.AudioPlayer.player.start(play_audio);
                    }catch(Exception x) { 
                        x.printStackTrace();
                    }  
         }else{
             AppConfig.Notify.toConsole("Due to mute mode, Sound unable to play...");
         }
    }
}
