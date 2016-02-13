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
package Util;

import AppConfig.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Loser
 */
public class Sysinfo {
    private String OS_Name;
    private String OS_Vir;
    private String JDK_Vir;
    private String User_Name;
    private String Core;
    private String Free_RAM;
    private String PC_Name;

    /**
     *
     */
    public static Object Sysinfo;

    /**
     *
     * @return
     */
    public String getMacAddress(){
            String macAddress = null;
            String command = "ifconfig";

            String osName = System.getProperty("os.name");
           // System.out.println("Operating System is " + osName);

    if (osName.startsWith("Windows")) {
        command = "ipconfig /all";
    } else if (osName.startsWith("Linux") || osName.startsWith("Mac") || osName.startsWith("HP-UX")
            || osName.startsWith("NeXTStep") || osName.startsWith("Solaris") || osName.startsWith("SunOS")
            || osName.startsWith("FreeBSD") || osName.startsWith("NetBSD")) {
        command = "ifconfig -a";
    } else if (osName.startsWith("OpenBSD")) {
        command = "netstat -in";
    } else if (osName.startsWith("IRIX") || osName.startsWith("AIX") || osName.startsWith("Tru64")) {
        command = "netstat -ia";
    } else if (osName.startsWith("Caldera") || osName.startsWith("UnixWare") || osName.startsWith("OpenUNIX")) {
        command = "ndstat";
    } else {    try {
        // Note: Unsupported system.
        throw new Exception("The current operating system '" + osName + "' is not supported.");
                } catch (Exception ex) {
                    Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    Process pid;
        try {
            pid = Runtime.getRuntime().exec(command);
  
    BufferedReader in = new BufferedReader(new InputStreamReader(pid.getInputStream()));
    Pattern p = Pattern.compile("([\\w]{1,2}(-|:)){5}[\\w]{1,2}");
    while (true) {
        String line = in.readLine();
      //  System.out.println("line " + line);
        if (line == null)
            break;

        Matcher m = p.matcher(line);
        if (m.find()) {
            macAddress = m.group();
            break;
        }
    }
    in.close();
          } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    return macAddress;
}

    /**
     *
     * @return
     */
    public String getPC_Name(){
        String hostname = "Unknown";
            try
            {
                InetAddress addr;
                addr = InetAddress.getLocalHost();
                hostname = addr.getHostName();
            }
            catch (UnknownHostException ex)
            {
                System.out.println("Hostname can not be resolved");
            }
            return hostname;
    }

    /**
     *
     * @return
     */
    public String getOS_Name() {
           this.OS_Name = System.getProperty("os.name");
        return OS_Name;
    }

    /**
     *
     * @return
     */
    public String getOS_Vir() {
             this.OS_Vir = System.getProperty("os.version");
        return OS_Vir;
    }

    /**
     *
     * @return
     */
    public String getJDK_Vir() {
          this.JDK_Vir = System.getProperty("java.version");
        return JDK_Vir;
    }

    /**
     *
     * @return
     */
    public String getUser_Name() {
         this.User_Name = System.getProperty("user.name");
        return User_Name;
    }
    
    /**
     *
     * @return
     */
    public String getCore() {
           Core=Long.toString(Runtime.getRuntime().availableProcessors());

        return Core;
    }

    /**
     *
     * @return
     */
    public String getFree_RAM() {
        Free_RAM=Long.toString(Runtime.getRuntime().freeMemory());
        return Free_RAM;
    }
}
