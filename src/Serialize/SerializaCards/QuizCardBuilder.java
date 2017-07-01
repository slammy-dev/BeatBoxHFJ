//package Serialize.SerializaCards;
//
//import javax.swing.*;
//import javax.swing.border.Border;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//
///**
// * Created by SuperDenissio on 30.06.2017.
// */
//public class QuizCardBuilder {
//    private JTextArea question;
//    private JTextArea answer;
//    private ArrayList<QuizCard> cardList;
//    private JFrame frame;
//
//    public static void main(String[] args) {
//        QuizCardBuilder builder = new QuizCardBuilder();
//        builder.go();
//    }
//
//    public void go(){
//        frame = new JFrame("Quiz Card Builder");
//        JPanel mainPanel = new JPanel();
//        Font bigFont = new Font(Font.SANS_SERIF,Font.BOLD,24);
//        question = new JTextArea(6,20);
//        question.setLineWrap(true);
//        question.setWrapStyleWord(true);
//        question.setFont(bigFont);
//
//        JScrollPane qScroller = new JScrollPane(question);
//        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//
//        answer = new JTextArea(6,20);
//        answer.setLineWrap(true);
//        answer.setWrapStyleWord(true);
//        answer.setFont(bigFont);
//
//        JScrollPane aScroller = new JScrollPane(answer);
//        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//
//        JButton nextButton = new JButton("Next Card");
//
//        cardList = new ArrayList<QuizCard>();
//
//        JLabel qLabel = new JLabel("Question:");
//        JLabel aLebel = new JLabel("Andswer:");
//
//        mainPanel.add(qLabel);
//        mainPanel.add(qScroller);
//        mainPanel.add(aLebel);
//        mainPanel.add(aScroller);
//        mainPanel.add(nextButton);
//        nextButton.addActionListener(new NextCardListener());
//        JMenuBar menuBar = new JMenuBar();
//        JMenu fileMenu = new JMenu("File");
//        JMenuItem newMenuItem = new JMenuItem("New");
//        JMenuItem saveMenuItem = new JMenuItem("Save");
//        newMenuItem.addActionListener(new NewMenuListener());
//        saveMenuItem.addActionListener(new SaveMenuListener());
//
//        fileMenu.add(newMenuItem);
//        fileMenu.add(saveMenuItem);
//        menuBar.add(fileMenu);
//        frame.setJMenuBar(menuBar);
//        frame.add(BorderLayout.CENTER,mainPanel);
//        frame.setSize(500,600);
//        frame.setVisible(true);
//    }
//
//    public class NextCardListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            QuizCard card = new QuizCard(question.getText(),answer.getText());
//            cardList.add(card);
//            clearCard();
//        }
//    }
//
//    public class SaveMenuListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            QuizCard card = new QuizCard(question.getText(),answer.getText());
//            cardList.add(card);
//            JFileChooser fileSave = new JFileChooser();
//            fileSave.showSaveDialog(frame);
//            saveFile(fileSave.getSelectedFile());
//        }
//    }
//
//    public class NewMenuListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            cardList.clear();
//            clearCard();
//        }
//    }
//
//    private void clearCard() {
//        question.setText("");
//        answer.setText("");
//        question.requestFocus();
//    }
//
//    private void saveFile(File file) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//
//            for (QuizCard card:cardList) {
//                writer.write(card.getQuestion()+"/");
//                writer.write(card.getAnswer()+"\n");
//            } writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Can't write this shit");
//        }
//    }
//}