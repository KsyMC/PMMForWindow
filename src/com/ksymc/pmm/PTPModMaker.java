package com.ksymc.pmm;

import java.awt.Color;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.bind.DatatypeConverter;

public class PTPModMaker extends JFrame {
	private static final long serialVersionUID = -7416095542646128977L;
	
	private DefaultListModel offsetListModel;
    private DefaultListModel valueListModel;
	private File patchFile;
    public boolean fileOpened;
    public boolean fileEdited;

    public PTPModMaker() {
        initComponents();
		setLocationRelativeTo(null);
    }

    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        howToDialog = new javax.swing.JDialog();
        javax.swing.JLabel descText = new javax.swing.JLabel();
        javax.swing.JLabel descText1 = new javax.swing.JLabel();
        javax.swing.JLabel descText2 = new javax.swing.JLabel();
        javax.swing.JLabel descText3 = new javax.swing.JLabel();
        javax.swing.JSeparator line1 = new javax.swing.JSeparator();
        javax.swing.JPanel mainPanel = new javax.swing.JPanel();
        valueListScrollPane = new javax.swing.JScrollPane();
        valueListModel = new javax.swing.DefaultListModel();
        valueList = new javax.swing.JList(valueListModel);
        javax.swing.JPanel offsetPanel = new javax.swing.JPanel();
        javax.swing.JButton addButton = new javax.swing.JButton();
        offsetTextField = new javax.swing.JTextField();
        javax.swing.JButton removeButton = new javax.swing.JButton();
        javax.swing.JButton upButton = new javax.swing.JButton();
        javax.swing.JButton downButton = new javax.swing.JButton();
        javax.swing.JLabel offsetText = new javax.swing.JLabel();
        javax.swing.JLabel valueText = new javax.swing.JLabel();
        javax.swing.JScrollPane valueTextScrollPane = new javax.swing.JScrollPane();
        valueTextField = new javax.swing.JTextArea();
        editButton = new javax.swing.JButton();
        javax.swing.JPanel metaPanel = new javax.swing.JPanel();
        javax.swing.JLabel autherText = new javax.swing.JLabel();
        autherTextField = new javax.swing.JTextField();
        javax.swing.JLabel versionText = new javax.swing.JLabel();
        versionTextField = new javax.swing.JTextField();
        javax.swing.JLabel infoText = new javax.swing.JLabel();
        infoTextField = new javax.swing.JTextField();
        offsetListScrollPane = new javax.swing.JScrollPane();
        offsetListModel = new javax.swing.DefaultListModel();
        offsetList = new javax.swing.JList(offsetListModel);
        javax.swing.JLabel offsetListText = new javax.swing.JLabel();
        javax.swing.JLabel valueListText = new javax.swing.JLabel();
        javax.swing.JLabel bottomText = new javax.swing.JLabel();
        javax.swing.JSeparator line = new javax.swing.JSeparator();
        javax.swing.JMenuBar menubar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem newMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem closeMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu editMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem undoMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem redoMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem howToMenuItem = new javax.swing.JMenuItem();

        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Mod 파일", "mod"));
        fileChooser.setAcceptAllFileFilterUsed(false);

        howToDialog.setTitle("사용법");
        howToDialog.setMinimumSize(new java.awt.Dimension(300, 300));
        howToDialog.setResizable(false);
        howToDialog.setLocationRelativeTo(null);

        descText.setText("<html>파일 메뉴를 이용해서 모드를 \"열기\" 로 열거나 \"새로 만들기\" 로 새로 시작할 수 있습니다.</html>");
        descText1.setText("<html>수정이나 이동, 삭제를 하실 때에는 [오프셋] 목록을 선택해서 작업해주세요.</html>");
        descText2.setText("<html>만든이 : KsyMC (ksy4362@naver.com)<html>");
        descText3.setText("이 프로그램은 PTPatch를 사용하였습니다.");

        javax.swing.GroupLayout howToDialogLayout = new javax.swing.GroupLayout(howToDialog.getContentPane());
        howToDialog.getContentPane().setLayout(howToDialogLayout);
        howToDialogLayout.setHorizontalGroup(
            howToDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(howToDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(howToDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descText, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(descText1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(descText3, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(line1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(descText2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        howToDialogLayout.setVerticalGroup(
            howToDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(howToDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descText, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descText1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descText2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descText3)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PMM for Window");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        valueListScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        valueListScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        valueList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        valueList.setToolTipText("추가된 값 입니다");
        valueList.setEnabled(false);
        valueListScrollPane.setViewportView(valueList);

        offsetPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("오프셋"));

        addButton.setText("추가");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        offsetTextField.setToolTipText("오프셋을 입력해 주세요");

        removeButton.setText("삭제");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        upButton.setText("위로");
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        downButton.setText("아래로");
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        offsetText.setText("오프셋:");

        valueText.setText("값 :");

        valueTextScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        valueTextField.setColumns(20);
        valueTextField.setFont(new java.awt.Font("굴림", 0, 12)); // NOI18N
        valueTextField.setLineWrap(true);
        valueTextField.setRows(5);
        valueTextField.setToolTipText("값을 입력해 주세요");
        valueTextScrollPane.setViewportView(valueTextField);

        editButton.setText("수정");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout offsetPanelLayout = new javax.swing.GroupLayout(offsetPanel);
        offsetPanel.setLayout(offsetPanelLayout);
        offsetPanelLayout.setHorizontalGroup(
            offsetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(upButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(downButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(offsetPanelLayout.createSequentialGroup()
                .addGroup(offsetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(valueText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(offsetText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(offsetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(offsetTextField)
                    .addComponent(valueTextScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        offsetPanelLayout.setVerticalGroup(
            offsetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(offsetPanelLayout.createSequentialGroup()
                .addGroup(offsetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(offsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(offsetText, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(offsetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valueTextScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(valueText, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(upButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(downButton)
                .addGap(0, 0, 0))
        );

        metaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("메타 정보"));

        autherText.setText("제작자 입력 :");

        autherTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        autherTextField.setText("KsyMC");
        autherTextField.setToolTipText("제작자를 입력해주세요");
        autherTextField.getDocument().addDocumentListener(new TextFieldDocument());
        autherTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autherTextFieldActionPerformed(evt);
            }
        });

        versionText.setText("MCPE 버전 :");

        versionTextField.setText("0");
        versionTextField.setToolTipText("MCPE 버전을 입력해 주세요");
        versionTextField.getDocument().addDocumentListener(new TextFieldDocument());

        javax.swing.GroupLayout metaPanelLayout = new javax.swing.GroupLayout(metaPanel);
        metaPanel.setLayout(metaPanelLayout);
        metaPanelLayout.setHorizontalGroup(
            metaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metaPanelLayout.createSequentialGroup()
                .addGroup(metaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(autherText)
                    .addComponent(versionText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(versionTextField)
                    .addComponent(autherTextField)))
        );
        metaPanelLayout.setVerticalGroup(
            metaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metaPanelLayout.createSequentialGroup()
                .addGroup(metaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(autherTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autherText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(metaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(versionText, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(versionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        infoText.setText("정보 :");

        infoTextField.setEditable(false);

        offsetListScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        offsetList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        offsetList.setToolTipText("추가된 오프셋 입니다");
        offsetList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                offsetListValueChanged(evt);
            }
        });
        offsetListScrollPane.setViewportView(offsetList);

        offsetListText.setText("오프셋 :");
        valueListText.setText("값 :");
        bottomText.setText("Made by KsyMC (ksy4362@naver.com)    |    http://cafe.naver.com/minecraftdev");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottomText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(offsetListText, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                        .addComponent(offsetListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addGap(0, 0, 0)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(valueListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                        .addComponent(valueListText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(offsetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(metaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                    .addComponent(infoText)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(infoTextField))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(offsetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(metaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valueListText, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(offsetListText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valueListScrollPane)
                            .addComponent(offsetListScrollPane))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoTextField)
                    .addComponent(infoText, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fileMenu.setText("File");

        newMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenuItem.setText("새로 만들기");
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newMenuItem);

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setText("열기");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText("저장");
        saveMenuItem.setEnabled(false);
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.setText("다른 이름으로 저장");
        saveAsMenuItem.setEnabled(false);
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        closeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        closeMenuItem.setText("종료");
        closeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(closeMenuItem);

        menubar.add(fileMenu);

        editMenu.setText("Edit");

        undoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undoMenuItem.setText("실행 취소");
        undoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(undoMenuItem);

        redoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        redoMenuItem.setText("다시 실행");
        redoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(redoMenuItem);

        menubar.add(editMenu);

        helpMenu.setText("Help");

        howToMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_MASK));
        howToMenuItem.setText("사용법");
        howToMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                howToMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(howToMenuItem);

        menubar.add(helpMenu);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuItemActionPerformed
        if (fileEdited) {
            int option = JOptionPane.showConfirmDialog(null,
                    "저장되지 않은 데이터가 있습니다. 정말로 새로 만드시겠습니까?",
                    "새로 만들기",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (option != JOptionPane.OK_OPTION) return;
        }
		reset();
    }//GEN-LAST:event_newMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            reset();
			fileOpen(fileChooser.getSelectedFile());
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        if (!fileOpened) {
            saveAsMenuItemActionPerformed(evt);
        } else {
            fileSave(patchFile);
        }
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        fileChooser.setSelectedFile(patchFile);
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            fileSave(fileChooser.getSelectedFile());
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void closeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMenuItemActionPerformed
        if (fileEdited) {
            int option = JOptionPane.showConfirmDialog(null,
                    "저장되지 않은 데이터가 있습니다. 정말로 종료 하시겠습니까?",
                    "새로 만들기",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (option != JOptionPane.OK_OPTION) return;
        }
        dispose();
    }

    private void undoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoMenuItemActionPerformed
        
    }

    private void redoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoMenuItemActionPerformed
        
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String[] values = getInputValue();
        if (values != null) {
            addListValue(values[0], values[1]);
        }
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        removeListValue(offsetList.getSelectedIndex());
    }//GEN-LAST:event_removeButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        upOrDownListValue(offsetList.getSelectedIndex(), true);
    }//GEN-LAST:event_upButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        upOrDownListValue(offsetList.getSelectedIndex(), false);
    }//GEN-LAST:event_downButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        String[] values = getInputValue();
        if (values != null) {
            editListValue(values[0], values[1]);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void offsetListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_offsetListValueChanged
        int index = offsetList.getSelectedIndex();
        if (index != -1) {
            editButton.setEnabled(true);
            valueList.setSelectedIndex(index);
            offsetTextField.setText((String) offsetListModel.get(index));
            valueTextField.setText((String) valueListModel.get(index));
        } else {
            editButton.setEnabled(false);
        }
    }//GEN-LAST:event_offsetListValueChanged

    private void howToMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_howToMenuItemActionPerformed
        howToDialog.setVisible(true);
    }

    private void autherTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autherTextFieldActionPerformed
        
    }

    public String[] getInputValue() {
        String [] ret = new String[2];
        String offset = offsetTextField.getText().trim().replaceAll("\\p{Space}", "").toUpperCase();
        String value = valueTextField.getText().trim().replaceAll("\\p{Space}", "").toUpperCase();
        if (!offset.equals("") && !value.equals("")) {
			if (offset.length() != 8) {
				setStatus(OFFSET_INPUT_ERROR);
				return null;
			}
            ret[0] = offset;
            ret[1] = value;
            return ret;
        }
        setStatus(OFFSET_OR_VALUE_INPUT_ERROR);
        return null;
    }

    public void addListValue(String offset, String value) {
        if (offsetListModel.indexOf(offset) == -1) {
            offsetListModel.addElement(offset);
            valueListModel.addElement(value);

            int index = valueListModel.getSize() - 1;
            valueList.setSelectedIndex(index);
            offsetList.setSelectedIndex(index);
			setFileEdited(true);
            setStatus(DONE);
        } else {
            setStatus(OFFSET_EXISTS);
        }
    }

    public void removeListValue(int index) {
        if (index != -1) {
            valueListModel.removeElementAt(index);
            offsetListModel.removeElementAt(index);
            if (index != 0) {
                valueList.setSelectedIndex(index - 1);
                offsetList.setSelectedIndex(index - 1);
            }
            setStatus(DONE);
        } else {
            setStatus(OFFSET_OR_VALUE_SELECTION_ERROR);
        }
    }

    public void editListValue(String offset, String value) {
        int index = offsetList.getSelectedIndex();
        if (offsetListModel.indexOf(offset) == -1 || (offsetListModel.indexOf(offset) != -1 && offsetListModel.get(index).equals(offset))) {
            offsetListModel.set(index, offset);
            valueListModel.set(index, value);
            setStatus(DONE);
        } else {
            setStatus(OFFSET_EXISTS);
        }
        setFileEdited(true);
    }

    public void upOrDownListValue(int index, boolean up) {
        if (index != -1) {
            if ((up && index != 0) || (!up && index != valueListModel.getSize() - 1)) {
                String value = (String) valueListModel.getElementAt(index);
                String offset = (String) offsetListModel.getElementAt(index);
                valueListModel.removeElementAt(index);
                offsetListModel.removeElementAt(index);
                if (up) index--;
                else index++;

                valueListModel.add(index, value);
                offsetListModel.add(index, offset);
                valueList.setSelectedIndex(index);
                offsetList.setSelectedIndex(index);
                setStatus(DONE);
                setFileEdited(true);
            } else {
                setStatus(UP_DOWN_ERROR);
            }
        } else {
            setStatus(OFFSET_OR_VALUE_SELECTION_ERROR);
        }
    }

    public void fileOpen(File file) {
        try {
            PTPatch patch = new PTPatch(file);
            if (patch.load()) {
                autherTextField.setText(new String(patch.getAuther(), "UTF-8"));
                versionTextField.setText("" + patch.getMCPEVersion());
				for (byte[] datas : patch.getData()) {
					String data = DatatypeConverter.printHexBinary(datas);
					offsetListModel.addElement(data.substring(0, 8));
					valueListModel.addElement(data.substring(8));
				}

                setStatus(DONE);
				setFileOpened(true, file);
                setFileEdited(false);
            } else {
                setStatus(HEADER_DAMAGED);
            }
        } catch (Exception e) {
            setStatus(FILE_OPEN_ERROR);
        }
    }

    public void fileSave(File file) {
		if (!file.getName().endsWith(".mod")) {
			file = new File(file.getAbsolutePath() + ".mod");
		}

        String version = versionTextField.getText().trim();
        String auther = autherTextField.getText().trim();
        if (!version.equals("") && !auther.equals("")) {
            try {
				int size = offsetListModel.getSize();
				byte[][] data = new byte[size][];
				for (int i = 0; i < size; i++) {
					String value = (String) offsetListModel.get(i) + valueListModel.get(i);
					data[i] = DatatypeConverter.parseHexBinary(value);
				}

				PTPatch patch = new PTPatch(file);
                patch.write(Integer.parseInt(version), size, auther, data);

				setStatus(FILE_SAVED);
                setFileOpened(true, file);
                setFileEdited(false);
            } catch(Exception e) {
                setStatus(FILE_SAVE_ERROR);
            }
        } else {
            setStatus(DATA_INPUT_ERROR);
        }
    }

	public void reset() {
		offsetListModel.removeAllElements();
        valueListModel.removeAllElements();
        autherTextField.setText("KsyMC");
        versionTextField.setText("0");
		setFileOpened(false, null);
		setFileEdited(false);
        setStatus(DONE);
	}

    public void setFileEdited(boolean edited) {
		fileEdited = edited;
		saveMenuItem.setEnabled(edited);
        if (fileOpened) {
            setTitle((edited ? "*" : "") + patchFile.getName()  + " - " + "PTP Mod Maker");
        } else {
            setTitle("PTP Mod Maker");
        }
    }

	public void setFileOpened(boolean opened, File file) {
		patchFile = file;
		fileOpened = opened;
		saveAsMenuItem.setEnabled(opened);
	}

    private void setStatus(int code) {
        String message = "";
        boolean error = false;
        switch(code) {
            case UNKNOWN_ERROR: error = true;
                message = "알 수 없는 오류 발생.";
                break;
            case FILE_SAVE_ERROR: error = true;
                message = "파일을 저장 할 수 없습니다.";
                break;
            case FILE_OPEN_ERROR: error = true;
                message = "파일을 열 수 없습니다.";
                break;
            case FILE_SAVED:
                message = "파일 저장이 완료되었습니다.";
                break;
            case OFFSET_OR_VALUE_INPUT_ERROR: error = true;
                message = "오프셋 또는 값을 입력해 주세요.";
                break;
            case OFFSET_OR_VALUE_SELECTION_ERROR: error = true;
                message = "오프셋 또는 값을 선택해 주세요.";
                break;
            case UP_DOWN_ERROR: error = true;
                message = "더이상 올리거나 내릴 수 없습니다.";
                break;
            case OFFSET_EXISTS: error = true;
                message = "이미 같은 오프셋이 존재합니다!";
                break;
            case HEADER_DAMAGED: error = true;
                message = "헤더가 손상되었습니다.";
                break;
            case DATA_INPUT_ERROR: error = true;
                message = "모든 정보가 입력되지 않았습니다!";
                break;
			case OFFSET_INPUT_ERROR: error = true;
                message = "오프셋을 정확하게 입력해 주세요! ex) 000F1AE0";
                break;
            case DONE:
                message = "완료.";
                break;
        }
        infoTextField.setText((error ? "오류 - " : "") + message);
        infoTextField.setForeground(error ? Color.RED : Color.BLACK);
    }

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PTPModMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PTPModMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PTPModMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PTPModMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PTPModMaker().setVisible(true);
            }
        });
    }

	public class TextFieldDocument implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			setFileEdited(true);
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			setFileEdited(true);
		}

		@Override
		public void changedUpdate(DocumentEvent e) {}
	}

    // setStatus
    public static final int UNKNOWN_ERROR = 0;
    public static final int FILE_SAVE_ERROR = 1;
    public static final int FILE_OPEN_ERROR = 2;
    public static final int FILE_SAVED = 3;
    public static final int OFFSET_OR_VALUE_INPUT_ERROR = 4;
    public static final int OFFSET_OR_VALUE_SELECTION_ERROR = 5;
    public static final int UP_DOWN_ERROR = 6;
    public static final int OFFSET_EXISTS = 7;
    public static final int HEADER_DAMAGED = 8;
    public static final int DATA_INPUT_ERROR = 9;
	public static final int OFFSET_INPUT_ERROR = 10;
    public static final int DONE = 11;

    private javax.swing.JTextField autherTextField;
    private javax.swing.JButton editButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JDialog howToDialog;
    private javax.swing.JTextField infoTextField;
    private javax.swing.JList offsetList;
    private javax.swing.JScrollPane offsetListScrollPane;
    private javax.swing.JTextField offsetTextField;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JList valueList;
    private javax.swing.JScrollPane valueListScrollPane;
    private javax.swing.JTextArea valueTextField;
    private javax.swing.JTextField versionTextField;
}
