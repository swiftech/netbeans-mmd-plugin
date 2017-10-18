/*
 * Copyright 2015 Igor Maznitsa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.igormaznitsa.nbmindmap.nb.swing;

import com.igormaznitsa.mindmap.model.logger.Logger;
import com.igormaznitsa.mindmap.model.logger.LoggerFactory;
import com.igormaznitsa.nbmindmap.utils.NbUtils;
import java.awt.Toolkit;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.openide.util.ImageUtilities;
import com.igormaznitsa.mindmap.ide.commons.SwingUtils;
import com.igormaznitsa.mindmap.swing.services.UIComponentFactory;
import com.igormaznitsa.mindmap.swing.services.UIComponentFactoryProvider;

public final class UriEditPanel extends javax.swing.JPanel {

  private static final long serialVersionUID = -6683682013891751388L;
  private static final UIComponentFactory UI_COMPO_FACTORY = UIComponentFactoryProvider.findInstance();
  private static final Logger LOGGER = LoggerFactory.getLogger(UriEditPanel.class);

  private static final ImageIcon IMAGE_OK = new ImageIcon(ImageUtilities.loadImage("com/igormaznitsa/nbmindmap/icons/tick16.png"));
  private static final ImageIcon IMAGE_BAD = new ImageIcon(ImageUtilities.loadImage("com/igormaznitsa/nbmindmap/icons/cancel16.png"));
  private static final ImageIcon IMAGE_QUESTION = new ImageIcon(ImageUtilities.loadImage("com/igormaznitsa/nbmindmap/icons/question16.png"));

  public UriEditPanel(final String uri) {
    initComponents();

    this.textFieldURI.setText(uri == null ? "" : uri);
    this.textFieldURI.setComponentPopupMenu(SwingUtils.addTextActions(UI_COMPO_FACTORY.makePopupMenu()));
    
    this.textFieldURI.getDocument().addDocumentListener(new DocumentListener() {

      @Override
      public void insertUpdate(DocumentEvent e) {
        validateUri();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        validateUri();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        validateUri();
      }
    });

    validateUri();
  }

  public String getText() {
    return this.textFieldURI.getText().trim();
  }

  private void validateUri() {
    final String text = this.textFieldURI.getText().trim();
    this.labelValidator.setText("");
    if (text.isEmpty()) {
      this.labelValidator.setIcon(IMAGE_QUESTION);
    }
    else {
      try {
        final URI uri = URI.create(text);
        if (uri.getScheme()!=null && uri.getHost()!=null) {
          this.labelValidator.setIcon(IMAGE_OK);
        }
        else {
          throw new NullPointerException();
        }
      }
      catch (Exception ex) {
        this.labelValidator.setIcon(IMAGE_BAD);
      }
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    labelBrowseCurrentLink = new javax.swing.JLabel();
    textFieldURI = new javax.swing.JTextField();
    labelValidator = new javax.swing.JLabel();
    buttonResetURI = new javax.swing.JButton();

    setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
    setLayout(new java.awt.GridBagLayout());

    labelBrowseCurrentLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/igormaznitsa/nbmindmap/icons/url_link.png"))); // NOI18N
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/igormaznitsa/nbmindmap/i18n/Bundle"); // NOI18N
    labelBrowseCurrentLink.setToolTipText(bundle.getString("UriEditPanel.labelBrowseCurrentLink.toolTipText")); // NOI18N
    labelBrowseCurrentLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    labelBrowseCurrentLink.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    labelBrowseCurrentLink.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        labelBrowseCurrentLinkMouseClicked(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 10;
    add(labelBrowseCurrentLink, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1000.0;
    add(textFieldURI, gridBagConstraints);

    labelValidator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    labelValidator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/igormaznitsa/nbmindmap/icons/question16.png"))); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 10;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    add(labelValidator, gridBagConstraints);

    buttonResetURI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/igormaznitsa/nbmindmap/icons/cross16.png"))); // NOI18N
    buttonResetURI.setFocusable(false);
    buttonResetURI.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonResetURIActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    add(buttonResetURI, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

  private void labelBrowseCurrentLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBrowseCurrentLinkMouseClicked
    if (evt.getClickCount() > 1) {
      try {
        NbUtils.browseURI(new URI(this.getText().trim()), false);
      }
      catch (URISyntaxException ex) {
        LOGGER.error("Can't start browser for URI syntax error", ex);
        Toolkit.getDefaultToolkit().beep();
      }
    }
  }//GEN-LAST:event_labelBrowseCurrentLinkMouseClicked

  private void buttonResetURIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetURIActionPerformed
    this.textFieldURI.setText("");
  }//GEN-LAST:event_buttonResetURIActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton buttonResetURI;
  private javax.swing.JLabel labelBrowseCurrentLink;
  private javax.swing.JLabel labelValidator;
  private javax.swing.JTextField textFieldURI;
  // End of variables declaration//GEN-END:variables
}
