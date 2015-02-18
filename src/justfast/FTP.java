package justfast;
 
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
 

public class FTP {
private String host,username,password;
    static int second;
    static int minute;
    static int hour;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
private String port;
private String path;
private String localFile;
public static Timer timer;
private int time = 1;
private String filename,modify,filesize;
public static boolean status = false;
private double kb,mb,gb;

    public String getKb() {
        NumberFormat rt = new DecimalFormat();
        setKb(Long.parseLong(filesize) /1024);
        return rt.format(Long.parseLong(filesize) /1024);
    }

    public void setKb(double kb) {
        this.kb = kb;
    }

    public String getMb() {
        
        NumberFormat rt = new DecimalFormat();
        setMb(kb/1024);
        return rt.format(kb/1024);
    }

    public void setMb(double mb) {
        this.mb = mb;
    }

    public String getGb() {
        NumberFormat rt = new DecimalFormat();
        return rt.format(mb/1024);
    }

    public void setGb(double gb) {
        this.gb = gb;
    }
    private URL url;
    private URLConnection uc;
    private OutputStream op;
    private FileInputStream fis;
    public static  int progresStatus;
    public static boolean process = true;
    public static int uploaded;
    private int kbps;
    private int buffer_size;

    public int getBuffer_size() {
        return buffer_size;
    }

    public void setBuffer_size(int buffer_size) {
        this.buffer_size = buffer_size;
    }
    
    public void filedata(String localFile){
        try {
            File file = new File(localFile);
            filename = file.getName();
            filesize = Long.toString( Files.size(file.toPath())) ;
            modify = Long.toString(file.lastModified());
        } catch (IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
     public void connect(JProgressBar progress, JLabel status,final JLabel kbpsLabel,final JLabel timeElapsed){
     try {
             // TODO code application logic here
             if(username.isEmpty() && password.isEmpty()){
                 url = new URL("ftp://"+host+":"+port+"/"+path+";type=i");
             }else{
             url = new URL("ftp://"+username+":"+password+"@"+host+":"+port+"/"+path+";type=i");
             }
             
             uc = url.openConnection();
             op = uc.getOutputStream();
             fis = new FileInputStream(localFile);
            
             byte[] buffer = new byte[buffer_size];
             int bytesRead = -1;
             uploaded = 0;
             second  = minute = hour = 00;
             process = true;
             timer =  new Timer();
             kbps = buffer_size;
              timer.scheduleAtFixedRate(new TimerTask() {

             @Override
             public void run() {
                 if(!process){
                     timer.cancel(); 
                 }
                 double kb = kbps / 1024;
                 double mbps = kb / 1024;
                kbpsLabel.setText(kbps +"Bps | " + Double.valueOf(kb) + "KBps | " + Double.valueOf(mbps)+"MBps");
                 
                if(second >= 59){
                     second  = 0;
                     if(minute >=  59){
                       minute = 0;
                       
                       hour++;
                      }
                     minute++;
                   }
                   second++;
                   timeElapsed.setText(getTimeFormat(hour)+":"+getTimeFormat(minute)+":"+getTimeFormat(second));
            
                 time += 1;
                 kbps = 0;
                 
             }
         }, 0, 1000);
            
             while((bytesRead = fis.read(buffer)) != -1){
                op.write(buffer,0,bytesRead);
                
                
                uploaded += bytesRead;
                kbps += bytesRead;
                double d = Double.parseDouble(Long.toString(uploaded)) / Double.parseDouble(filesize) ;
                int uploaded = (int) (d * 100);
                progresStatus = uploaded;
                
             }
              process = false;
              timer.cancel();
              kbpsLabel.setText("0kbps");
//              if(time < 61){
//              timeElapsed.setText(time+" Seconds");
//              }else{
//              timeElapsed.setText(time/60+" minutes");
//              }
              if(second >= 59){
                     second  = 0;
                     if(minute >=  59){
                       minute = 0;
                       
                       hour++;
                      }
                     minute++;
                   }
                   second++;
                   timeElapsed.setText(getTimeFormat(hour)+":"+getTimeFormat(minute)+":"+getTimeFormat(second));
              time = 1;
        } catch (MalformedURLException ex) {
             process = false;
              if(timer != null)timer.cancel();
             status.setText("F172: Sorry error occured, unable to upload file...");
             javax.swing.JOptionPane.showMessageDialog(null, "Error:F119 "+ex.getMessage(),null,JOptionPane.ERROR_MESSAGE);
        }catch (IOException ex) {
             process = false;
             if(timer != null)timer.cancel();
             status.setText("F175: Sorry error occured, unable to upload file...");
             javax.swing.JOptionPane.showMessageDialog(null, "Error:F124 "+ ex.getMessage(),null,JOptionPane.ERROR_MESSAGE);
        } finally{
             try {
                 progress.setValue(0);
                 fis.close();
                 op.close();
              
                 
             } catch (IOException ex) {
                  if(timer != null)timer.cancel();
                  process = false;
                 status.setText("F190: Sorry error occured, unable to upload file...");
                 javax.swing.JOptionPane.showMessageDialog(null, "Error:F136 "+ex.getMessage(),null,JOptionPane.ERROR_MESSAGE);
             }catch(NullPointerException ex){
               process = false;
                if(timer != null)timer.cancel();
                  status.setText("F195: Sorry error occured, unable to upload file...");
                 javax.swing.JOptionPane.showMessageDialog(null, "Error:F136 "+ex.getMessage(),null,JOptionPane.ERROR_MESSAGE);
           
             }
      }
      if(timer != null)timer.cancel();
     }
     
     
   
    public void setHost(String host) {
        this.host = host;
    }
    public  String getTimeFormat(int i){
           String x ;//= "00"; 
           if(i < 10){
              x = "0" + Integer.toString(i);
            }else{
             x = Integer.toString(i);
           }
           return x;
       }
    public void setPort(String port) {
        this.port = port;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setLocalFile(String localFile) {
        this.localFile = localFile;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public String getLocalFile() {
        return localFile;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getModify() {
        Timestamp ts = new Timestamp(Long.parseLong(modify));
        return ts.toLocaleString();
       
    }

    public void setModify(String modify) {
       
        this.modify = modify;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

          
      
}
