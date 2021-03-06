/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsatry2.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import tsatry2.encrypt.Ide;
import static tsatry2.encrypt.Ide.isInteger;
import static tsatry2.encrypt.Ide.setText;

/**
 *
 * @author Henry
 */
public class calcUI extends javax.swing.JFrame {

    /**
     * Creates new form calcUI
     */
    public calcUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        fileOut = new javax.swing.ButtonGroup();
        encryptBt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextField = new javax.swing.JTextArea();
        textA = new javax.swing.JTextField();
        textB = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        statusText = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        clearFields = new javax.swing.JButton();
        importButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        entryTextField = new javax.swing.JTextArea();
        fieldOut = new javax.swing.JRadioButton();
        fileOnly = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        encryptBt.setText("Encrypt");
        encryptBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptBtActionPerformed(evt);
            }
        });

        outputTextField.setEditable(false);
        outputTextField.setColumns(20);
        outputTextField.setRows(5);
        jScrollPane1.setViewportView(outputTextField);

        textA.setToolTipText("Calculation #1");

        textB.setToolTipText("Calculation #2");
        textB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBKeyReleased(evt);
            }
        });

        statusText.setEditable(false);
        statusText.setColumns(20);
        statusText.setRows(1);
        jScrollPane3.setViewportView(statusText);

        jLabel1.setText("Must be a #>0");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Rose Hill Quark Robotics Encryption");

        saveButton.setText("Save To File");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        clearFields.setText("Clear all fields");
        clearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFieldsActionPerformed(evt);
            }
        });

        importButton.setText("Import From File");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        entryTextField.setColumns(20);
        entryTextField.setRows(5);
        jScrollPane2.setViewportView(entryTextField);

        fileOut.add(fieldOut);
        fieldOut.setSelected(true);
        fieldOut.setText("Output to text field");
        fieldOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldOutActionPerformed(evt);
            }
        });

        fileOut.add(fileOnly);
        fileOnly.setText("Save to file");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(encryptBt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fieldOut)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fileOnly))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textA, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textB, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(importButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearFields)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(jLabel2)
                    .addComponent(saveButton)
                    .addComponent(clearFields)
                    .addComponent(importButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(encryptBt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldOut)
                        .addComponent(fileOnly))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>                        

    private void encryptBtActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        Double dA = 0.0;//var init
        Double dB = 0.0;
        
        if(isInteger(textA.getText()) && isInteger(textB.getText())){//checking to make sure input are ints
            dA = Double.parseDouble(textA.getText());//put text into double
            dB = Double.parseDouble(textB.getText());
            if(dA<0 | dB<0){
                setText("Error: Encryption variables are less than zero.");
            }
        }else{
            setText("Error: Encryption variables not valid.");
            return;
        }
        BigDecimal bdA = new BigDecimal(dA);//put doubles into big decimals
        BigDecimal bdB = new BigDecimal(dB);
        String field;
        field = entryTextField.getText();//getting entry text
        System.out.println(field);
        BigDecimal[] Input = Ide.encrypt(field, bdA, bdB, 0);//running encryption into array of bigdecimals
        System.out.println("Array Length" + Input.length);
        if(fieldOut.isSelected()){
            outputTextField.setText("");
            String output = "";
            for (int i = 0; i < Input.length; i++) {//all bigdecimals
                statusText.setText("Outputting line: " + String.valueOf(i) + " of " + Input.length);
                statusText.update(statusText.getGraphics());
                outputTextField.append(Input[i].toPlainString() + "\n");//add all bigdecimals to output
    //            System.out.println("Output: "+output);
                if (i < 30) {//update only the first 30 lines
                    outputTextField.update(outputTextField.getGraphics());
                }
            }
            outputTextField.update(outputTextField.getGraphics());//update at the end
        }else{
            try {
                statusText.setText("Writing to file. Please Wait");
                statusText.update(statusText.getGraphics());
                PrintWriter out = new PrintWriter("encrypted.txt");//start a printwriter
                for (int i = 0; i < Input.length; i++) {//all bigdecimals
                    out.print(Input[i].toPlainString() + "\n");//add all bigdecimals to output
                }
                out.close();
                statusText.setText("Done writing to file.");
                statusText.update(statusText.getGraphics());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(calcUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        statusText.setText("Done.");
        statusText.update(statusText.getGraphics());
    }                                         

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String[] args = {""};//blank string
        startUI.main(args);//start startUI
        dispose();//close this ui
    }                                          

    private void textBKeyReleased(java.awt.event.KeyEvent evt) {                                  
        // TODO add your handling code here:
    }                                 

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
            statusText.setText("Writing to file. Please Wait");
            statusText.update(statusText.getGraphics());
            PrintWriter out = new PrintWriter("encrypted.txt");//start a printwriter
            out.print(outputTextField.getText());//put output into file
            out.close();
            statusText.setText("Done writing to file.");
            statusText.update(statusText.getGraphics());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(calcUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                          

    private void clearFieldsActionPerformed(java.awt.event.ActionEvent evt) {                                            
        outputTextField.setText("");//set all text to blank strings
        textA.setText("");
        textB.setText("");
        entryTextField.setText("");
        statusText.setText("");
    }                                           

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        final JFileChooser fc = new JFileChooser();//start file chooser
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);//file filters
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");//file filters
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(calcUI.this);//open file chooser gui
        String input = null;
        String line = null;
        entryTextField.setText("");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File inputFile;
            inputFile = fc.getSelectedFile();//get file
            input = inputFile.toString();// get file path
        }
        try {
            FileReader fileReader = new FileReader(input);//start buffered reader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {//read all lines
                entryTextField.append(line + "\n");//add all lines to entry
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '"
                + input + "'");
        } catch (IOException ex) {
            System.out.println(
                "Error reading file '"
                + input + "'");
        }
    }                                            

    private void fieldOutActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(calcUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calcUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calcUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calcUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calcUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearFields;
    private javax.swing.JButton encryptBt;
    private javax.swing.JTextArea entryTextField;
    private javax.swing.JRadioButton fieldOut;
    private javax.swing.JRadioButton fileOnly;
    private javax.swing.ButtonGroup fileOut;
    private javax.swing.JButton importButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextArea outputTextField;
    private javax.swing.JButton saveButton;
    public static javax.swing.JTextArea statusText;
    private javax.swing.JTextField textA;
    private javax.swing.JTextField textB;
    // End of variables declaration                   
}
