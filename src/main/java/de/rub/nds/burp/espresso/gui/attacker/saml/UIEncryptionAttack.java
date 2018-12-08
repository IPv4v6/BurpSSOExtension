/**
 * EsPReSSO - Extension for Processing and Recognition of Single Sign-On Protocols.
 * Copyright (C) 2015 Tim Guenther and Christian Mainka
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package de.rub.nds.burp.espresso.gui.attacker.saml;

import com.beetstra.jutf7.CharsetProvider;
import de.rub.nds.burp.espresso.gui.attacker.IAttack;
import de.rub.nds.burp.utilities.ByteArrayHelper;
import de.rub.nds.burp.utilities.Logging;
import de.rub.nds.burp.utilities.XMLHelper;
import de.rub.nds.burp.utilities.listeners.AbstractCodeEvent;
import de.rub.nds.burp.utilities.listeners.CodeListenerController;
import de.rub.nds.burp.utilities.protocols.xmlenc.AsymmetricAlgorithm;
import de.rub.nds.burp.utilities.protocols.xmlenc.SymmetricAlgorithm;
import de.rub.nds.burp.utilities.protocols.xmlenc.XmlEncryptionHelper;
import java.awt.Dimension;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Encryption Attack
 *
 * @author Nurullah Erinola
 * @author Juraj Somorovsky
 * @version 1.0
 */
public class UIEncryptionAttack extends javax.swing.JPanel implements IAttack {

    private int pos;
    private String saml = "";
    private CodeListenerController listeners = null;
    private XmlEncryptionHelper xmlEncryptionHelper;

    /**
     * Creates new form UIDTDAttack
     */
    public UIEncryptionAttack() {
        initComponents();
        initEditorsAndListener();
        xmlEncryptionHelper = new XmlEncryptionHelper();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sysPubButtonGroup = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSymmetricKey = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaCertificate = new javax.swing.JTextArea();
        jComboBoxPublicAlgo = new javax.swing.JComboBox<>();
        jButtonEncryptSymmetricKey = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaEncryptedKey = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaXmlData = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaCipherData = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxSymmetricAlgo = new javax.swing.JComboBox<>();
        jButtonEncryptXML = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextAreaXmlHex = new javax.swing.JTextArea();

        jLabel3.setText("Certificate:");

        jTextAreaSymmetricKey.setColumns(20);
        jTextAreaSymmetricKey.setLineWrap(true);
        jTextAreaSymmetricKey.setRows(5);
        jTextAreaSymmetricKey.setText("01 02 03 04 05 06 07 08 01 02 03 04 05 06 07 08");
        jScrollPane1.setViewportView(jTextAreaSymmetricKey);

        jLabel1.setText("Public key encryption:");

        jTextAreaCertificate.setColumns(20);
        jTextAreaCertificate.setRows(5);
        jTextAreaCertificate.setText("-----BEGIN CERTIFICATE-----\n\n-----END CERTIFICATE-----");
        jScrollPane3.setViewportView(jTextAreaCertificate);

        jComboBoxPublicAlgo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPublicAlgo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPublicAlgoActionPerformed(evt);
            }
        });

        jButtonEncryptSymmetricKey.setText("Encrypt");
        jButtonEncryptSymmetricKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncryptSymmetricKeyActionPerformed(evt);
            }
        });

        jLabel4.setText("Symmetric key:");
        jLabel4.setToolTipText("Will be encrypted with the server public key.");

        jLabel5.setText("EncryptedKey:");

        jTextAreaEncryptedKey.setEditable(false);
        jTextAreaEncryptedKey.setColumns(20);
        jTextAreaEncryptedKey.setLineWrap(true);
        jTextAreaEncryptedKey.setRows(5);
        jScrollPane2.setViewportView(jTextAreaEncryptedKey);

        jLabel6.setText("Symmetric key encryption:");

        jLabel7.setText("XML data:");

        jTextAreaXmlData.setColumns(20);
        jTextAreaXmlData.setLineWrap(true);
        jTextAreaXmlData.setRows(5);
        jTextAreaXmlData.setText("<saml:Assertion xmlns:saml=\"urn:oasis:names:tc:SAML:2.0:assertion\" Version=\"2.0\" ID=\"_009df3b376b737bdb3fd890f6740543e9ca17c4e71\" IssueInstant=\"2018-03-04T12:46:12Z\">\n</saml:Assertion>");
        jTextAreaXmlData.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextAreaXmlDataPropertyChange(evt);
            }
        });
        jScrollPane4.setViewportView(jTextAreaXmlData);

        jLabel8.setText("CipherData:");

        jTextAreaCipherData.setEditable(false);
        jTextAreaCipherData.setColumns(20);
        jTextAreaCipherData.setLineWrap(true);
        jTextAreaCipherData.setRows(5);
        jScrollPane5.setViewportView(jTextAreaCipherData);

        jLabel2.setText("Algorithm:");

        jLabel10.setText("Algorithm:");

        jComboBoxSymmetricAlgo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonEncryptXML.setText("Encrypt");
        jButtonEncryptXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncryptXMLActionPerformed(evt);
            }
        });

        jTextAreaXmlHex.setColumns(20);
        jTextAreaXmlHex.setLineWrap(true);
        jTextAreaXmlHex.setRows(5);
        jScrollPane6.setViewportView(jTextAreaXmlHex);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(jComboBoxPublicAlgo, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEncryptSymmetricKey))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)))
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(30, 30, 30)
                        .addComponent(jComboBoxSymmetricAlgo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEncryptXML))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPublicAlgo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEncryptSymmetricKey)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSymmetricAlgo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEncryptXML)
                    .addComponent(jLabel10)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEncryptSymmetricKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncryptSymmetricKeyActionPerformed
        String certificate = jTextAreaCertificate.getText();
        byte[] symmetricKey = ByteArrayHelper.hexStringToByteArray(jTextAreaSymmetricKey.getText());
        xmlEncryptionHelper.setSymmetricKey(symmetricKey);
        String algorithmURI = jComboBoxPublicAlgo.getItemAt(jComboBoxPublicAlgo.getSelectedIndex());
        AsymmetricAlgorithm algorithm = AsymmetricAlgorithm.getByURI(algorithmURI);
        try {
            String encryptedKey = xmlEncryptionHelper.encryptKey(certificate, algorithm);
            jTextAreaEncryptedKey.setText(encryptedKey);
            jTextAreaEncryptedKey.selectAll();
            jTextAreaEncryptedKey.copy();
        } catch (InvalidKeyException | NoSuchAlgorithmException | CertificateException | BadPaddingException
                | IllegalBlockSizeException | NoSuchPaddingException ex) {
            Logging.getInstance().log(getClass(), ex);
        }
    }//GEN-LAST:event_jButtonEncryptSymmetricKeyActionPerformed

    private void jComboBoxPublicAlgoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPublicAlgoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPublicAlgoActionPerformed

    private void jButtonEncryptXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncryptXMLActionPerformed
        byte[] symmetricKey = ByteArrayHelper.hexStringToByteArray(jTextAreaSymmetricKey.getText());
        xmlEncryptionHelper.setSymmetricKey(symmetricKey);
        String algorithmURI = jComboBoxSymmetricAlgo.getItemAt(jComboBoxSymmetricAlgo.getSelectedIndex());
        SymmetricAlgorithm algorithm = SymmetricAlgorithm.getByURI(algorithmURI);
        String hexXml = jTextAreaXmlHex.getText();
        byte[] data = ByteArrayHelper.hexStringToByteArray(hexXml);
        try {
            String result = xmlEncryptionHelper.encryptData(data, algorithm);
            jTextAreaCipherData.setText(result);
            jTextAreaCipherData.selectAll();
            jTextAreaCipherData.copy();
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException
                | IllegalBlockSizeException | InvalidAlgorithmParameterException | NoSuchPaddingException ex) {
            Logging.getInstance().log(getClass(), ex);
        }
    }//GEN-LAST:event_jButtonEncryptXMLActionPerformed

    private void jTextAreaXmlDataPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextAreaXmlDataPropertyChange

    }//GEN-LAST:event_jTextAreaXmlDataPropertyChange

    /**
     * Is called every time new Code is available.
     *
     * @param evt {@link de.rub.nds.burp.utilities.listeners.AbstractCodeEvent}
     * The new source code.
     */
    @Override
    public void setCode(AbstractCodeEvent evt) {
        this.saml = evt.getCode();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEncryptSymmetricKey;
    private javax.swing.JButton jButtonEncryptXML;
    private javax.swing.JComboBox<String> jComboBoxPublicAlgo;
    private javax.swing.JComboBox<String> jComboBoxSymmetricAlgo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextAreaCertificate;
    private javax.swing.JTextArea jTextAreaCipherData;
    private javax.swing.JTextArea jTextAreaEncryptedKey;
    private javax.swing.JTextArea jTextAreaSymmetricKey;
    private javax.swing.JTextArea jTextAreaXmlData;
    private javax.swing.JTextArea jTextAreaXmlHex;
    private javax.swing.ButtonGroup sysPubButtonGroup;
    // End of variables declaration//GEN-END:variables

    private void initEditorsAndListener() {
        jComboBoxPublicAlgo.setModel(new DefaultComboBoxModel(AsymmetricAlgorithm.getURIs()));
        jComboBoxPublicAlgo.setSelectedIndex(0);
        jComboBoxSymmetricAlgo.setModel(new DefaultComboBoxModel(SymmetricAlgorithm.getURIs()));
        jComboBoxSymmetricAlgo.setSelectedIndex(0);
        jTextAreaXmlData.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateHexData();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateHexData();
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                updateHexData();
            }
        });
    }

    private void updateHexData() {
        String algorithmURI = jComboBoxSymmetricAlgo.getItemAt(jComboBoxSymmetricAlgo.getSelectedIndex());
        SymmetricAlgorithm algorithm = SymmetricAlgorithm.getByURI(algorithmURI);
        byte[] xml = jTextAreaXmlData.getText().getBytes();
        byte[] padding = xmlEncryptionHelper.computePadding(xml, algorithm);
        byte[] data = ByteArrayHelper.concatenate(xml, padding);
        jTextAreaXmlHex.setText(ByteArrayHelper.bytesToHexString(data));
    }

    /**
     * Set the listener for the editor.
     *
     * @param listeners
     * {@link de.rub.nds.burp.utilities.listeners.CodeListenerController}
     */
    @Override
    public void setListener(CodeListenerController listeners) {
        this.listeners = listeners;
        this.listeners.addCodeListener(this);
    }

    /**
     * Notify all registered listeners with the new code.
     *
     * @param code The new source code.
     */
    @Override
    public void notifyAllTabs(AbstractCodeEvent evt) {
        if(listeners != null){
            listeners.notifyAll(evt);
        }
    }
}
