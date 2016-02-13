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

import static Sound.Audio_Player.play;
import javafx.application.Platform;

/**
 *
 * @author Loser
 */
public class PlaySound extends Audio_Player{
    
    /**
     *
     */
    public static void ErrorSound(){
                 Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        play("typing_error");
                                    }
                  });
        
    }
}