/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package justfast;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Acer
 */

public class View extends javax.swing.JFrame {
private FTP ftp;
 XML xml;

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        ftp = new FTP();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getWidth()/2),( Toolkit.getDefaultToolkit().getScreenSize().height/2 )- this.getHeight()/2);
       
        xml = new XML();
        xml.read();
        localFile.setText(xml.info.get("local-file"));
        ftpHost.setText(xml.info.get("ftp-host"));
        ftpPath.setText(xml.info.get("ftp-dir"));
        ftpPort.setText(xml.info.get("ftp-port"));
        speed.setText(xml.info.get("speed"));
        username.setText(xml.info.get("username"));
        password.setText(xml.info.get("password"));
        dataSetup();
        setIcon();
    }
 private void setIcon() {
        try {
            ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
            images.add(ImageIO.read(getClass().getResource("justfast.png")));
            images.add(ImageIO.read(getClass().getResource("justfast.png")));
            images.add(ImageIO.read(getClass().getResource("justfast.png")));
            images.add(ImageIO.read(getClass().getResource("justfast.png")));
            setIconImages(images);
         
            //  setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("spriteSheetMakerLogo.png")));
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void dataSetup(){
        ftp.filedata(localFile.getText());
        filename.setText(ftp.getFilename());
        filesize.setText(ftp.getFilesize()+" Bytes | " + ftp.getKb() + " KB | "+ftp.getMb()+"MB");
        filemodified.setText(ftp.getModify());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        localFile = new javax.swing.JTextField();
        selectLocalFile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ftpHost = new javax.swing.JTextField();
        Upload = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ftpPort = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ftpPath = new javax.swing.JTextField();
        ftpSelectDir = new javax.swing.JButton();
        progress = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        filename = new javax.swing.JLabel();
        filesize = new javax.swing.JLabel();
        filemodified = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        speed = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        kbps = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        uploadedTime = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JustFast");
        setResizable(false);

        jLabel1.setText("Local File:");

        localFile.setText("C:\\Users\\Acer\\workspace\\ColorBlind\\bin\\ColorBlind.apk");

        selectLocalFile.setText("Select");
        selectLocalFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectLocalFileActionPerformed(evt);
            }
        });

        jLabel2.setText("FTP:");

        ftpHost.setText("192.168.137.50");

        Upload.setText("Upload");
        Upload.setFocusCycleRoot(true);
        Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadActionPerformed(evt);
            }
        });

        jLabel3.setText("Port");

        ftpPort.setText("8888");

        jLabel4.setText("FTP Dir:");

        ftpPath.setText("mnt/sdcard/apk");

        ftpSelectDir.setText("Select");
        ftpSelectDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftpSelectDirActionPerformed(evt);
            }
        });

        jLabel5.setText("Status:");

        status.setText("Doing Nothing");

        jLabel6.setText("Filename:");

        jLabel7.setText("File Size:");

        jLabel8.setText("File Last Modified:");

        filename.setText("ColorBlind.apk");

        filesize.setText("0kb");

        filemodified.setText("0:0:0");

        jLabel9.setText("Speed");

        speed.setText("1024");

        jLabel12.setText("Transfer Speed:");

        kbps.setText("0");

        jLabel13.setText("File Uploaded in:");

        uploadedTime.setText("0s");

        jLabel14.setText("Userrname:");

        jLabel15.setText("Password:");

        username.setText("samu");

        password.setText("samu");

        jLabel16.setText("Bytes");

        jMenu1.setText("Menu");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Select Local File");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        jMenuItem3.setText("Upload");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("For What?");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Developer");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uploadedTime, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(273, 273, 273))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(filename, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(filemodified)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(localFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectLocalFile))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(password))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(ftpHost, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ftpPort)
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(speed, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel16))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(username)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(ftpPath, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(ftpSelectDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                            .addComponent(Upload, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filesize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kbps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(localFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectLocalFile))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftpHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ftpPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(speed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ftpPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftpSelectDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(filename))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(filesize))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(filemodified))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(kbps, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(uploadedTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadActionPerformed
        // TODO add your handling code here:
       Upload.setEnabled(false);
              FTPSetup();     
              progressReports();  
                  
        
    }//GEN-LAST:event_UploadActionPerformed
 private void getViewData(){
 ftp.setHost(ftpHost.getText());
                    ftp.setPath(ftpPath.getText()+"/"+ftp.getFilename());
                    ftp.setPort(ftpPort.getText());
                    ftp.setUsername(username.getText());
                    ftp.setPassword(password.getText());
                    ftp.setBuffer_size(Integer.parseInt(speed.getText()));
                    ftp.setLocalFile(localFile.getText());
 }
     
    private void FTPSetup(){
    new Thread(){ 

            @Override
            public void run() {
                    
                    
                    getViewData();
                    ftp.connect(progress,status,kbps,uploadedTime);
                    String[] d = {ftp.getLocalFile(),ftp.getHost(),ftp.getPort(),ftp.getBuffer_size()+"",ftpPath.getText(),ftp.getUsername(),ftp.getPassword()};
                    xml.write(d);
                    
            }
        
       
    
    }.start();
    }
    private void progressReports(){
        Thread t2 =  new Thread(){

            @Override
            public void run() {
                while(true){
               //   System.out.println("helllo");
                status.setText("Uploading ... " + FTP.uploaded / 1024+ " KB Uploaded... of " + ftp.getKb()+" kb("+ftp.getMb()+"mb)");
                progress.setValue(FTP.progresStatus);
                if(!FTP.process){
                    if(FTP.progresStatus != 0 ){
                    status.setText("File Has been Uploaded ");
                    }
                    progress.setValue(0);
                    FTP.process = true;
                    FTP.uploaded = 0;
                    //FTP.second  = FTP.minute = FTP.hour = 00;
                    FTP.progresStatus = 0;
                    Upload.setEnabled(true);
                    break;
                 }
                }
                
                
            }
        };
       
       t2.start();
    }
    private void selectLocalFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectLocalFileActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
       
       chooser.setCurrentDirectory(new File(localFile.getText()));
      chooser.setDialogTitle("please choose song directory");
    //  chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
          if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                String paths = chooser.getSelectedFile().toString();
                 if(!paths.isEmpty()){
                       
                        localFile.setText(chooser.getSelectedFile().toString());
                        dataSetup();
                      //  ftpPath.setText(ftpPath.getText()+"/"+ftp.getFilename());
                  }
          }
       
       
    }//GEN-LAST:event_selectLocalFileActionPerformed

    private void ftpSelectDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftpSelectDirActionPerformed
        // TODO add your handling code here:
        try{
        JFileChooser chooser = new JFileChooser();
       chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
       chooser.setCurrentDirectory(new File("ftp://"+ftpHost+":"+ftpPort+"/"+ftpPath));
      chooser.setDialogTitle("please choose song directory");
      chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
          if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                String paths = chooser.getSelectedFile().toString();
                 if(!paths.isEmpty()){
                   if(Files.isDirectory(new File(paths).toPath(), (LinkOption) null)){
                        ftpPath.setText(chooser.getSelectedFile().toString());
                   }else{
                      javax.swing.JOptionPane.showMessageDialog(null, "This is not correct Directory");
                   }
                  }
          }}
        catch(Exception e){
        javax.swing.JOptionPane.showMessageDialog(null, "Couldn't find the file");
        }
    }//GEN-LAST:event_ftpSelectDirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        javax.swing.JOptionPane.showMessageDialog(null, "Developed By Samundra Kc (http://samundrakc.com.np | samundrak@yahoo.com)");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
              javax.swing.JOptionPane.showMessageDialog(null, "To send File to mobile FTP (Android) fast but can be used in other ftp also");
   
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        UploadActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        
        selectLocalFileActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Upload;
    private javax.swing.JLabel filemodified;
    private javax.swing.JLabel filename;
    private javax.swing.JLabel filesize;
    private javax.swing.JTextField ftpHost;
    private javax.swing.JTextField ftpPath;
    private javax.swing.JTextField ftpPort;
    private javax.swing.JButton ftpSelectDir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JLabel kbps;
    private javax.swing.JTextField localFile;
    private javax.swing.JPasswordField password;
    private javax.swing.JProgressBar progress;
    private javax.swing.JButton selectLocalFile;
    private javax.swing.JTextField speed;
    private javax.swing.JLabel status;
    private javax.swing.JLabel uploadedTime;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
