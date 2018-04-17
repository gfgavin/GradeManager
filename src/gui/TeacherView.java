package gui;

import controllers.TeacherController;
import course.Assignment;
import course.Course;
import javax.swing.*;
import db.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class TeacherView extends javax.swing.JFrame {

    private TeacherController teacherController;

    /**
     * Creates new form Test
     */
    public TeacherView() {
        initComponents();
        jPanel3.add(new JButton("asdf"));
    }

    void setTeacher(String username) {
        teacherController = new TeacherController(username);
        ArrayList<Course> courseList = teacherController.getCourseList();

        jTextArea1.setText(teacherController.toString());

        DefaultTableModel model = (DefaultTableModel) teacherClassTable.getModel();
        model.getDataVector().removeAllElements();
        int i = 0;
        for (Course t : courseList) {
            model.insertRow(i, new Object[]{t.toString()});
            i++;

        }
        for (int j = courseList.size(); j < 25; j++) {
            model.addRow(new Object[]{" "});
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        teacherClassTable = new javax.swing.JTable();
        viewAssignments = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        addAssignmentButton = new javax.swing.JButton();
        viewGradesButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        assignmentTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        studentGradeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        enterGradeTextField = new javax.swing.JTextField();
        updateGradeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        assignmentTitleTextField = new javax.swing.JTextField();
        courseLabel = new javax.swing.JLabel();
        assignmentLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jScrollPane5.setName(""); // NOI18N

        teacherClassTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Classes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        teacherClassTable.setName(""); // NOI18N
        teacherClassTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(teacherClassTable);

        viewAssignments.setText("View Assignments For Selected Class");
        viewAssignments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAssignmentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(viewAssignments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewAssignments)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addContainerGap(580, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        addAssignmentButton.setText("Add New Assignment");
        addAssignmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAssignmentButtonActionPerformed(evt);
            }
        });

        viewGradesButton.setText("View Grades for Assignment");
        viewGradesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewGradesButtonActionPerformed(evt);
            }
        });

        assignmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Assignments"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        assignmentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(assignmentTable);

        jScrollPane3.setName(""); // NOI18N

        studentGradeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Students"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentGradeTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(studentGradeTable);

        jLabel1.setText("Enter Grade:");

        updateGradeButton.setText("Update Grade");
        updateGradeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateGradeButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("New Assignment Title:");

        courseLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        courseLabel.setText(" ");

        assignmentLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        assignmentLabel.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(addAssignmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(viewGradesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addComponent(assignmentTitleTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(courseLabel))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateGradeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enterGradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(assignmentLabel))
                .addGap(0, 326, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseLabel)
                    .addComponent(assignmentLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewGradesButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(enterGradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateGradeButton)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assignmentTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addAssignmentButton)
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1691, 1691, 1691))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void viewAssignmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAssignmentsActionPerformed
        int row = teacherClassTable.getSelectedRow();

        ArrayList<Course> courseList = teacherController.getCourseList();
        if (row > courseList.size() - 1 || row < 0) {
            return;
        }

        //show assignments and grades for selected course
        int courseId = courseList.get(row).getCourseID();
        //String grades = teacherController.viewGradesForCourse(courseId);

        ArrayList<Assignment> assignmentList = teacherController.getAssignmentsForCourse(courseId);

        DefaultTableModel model = (DefaultTableModel) assignmentTable.getModel();
        model.getDataVector().removeAllElements();
        int i = 0;
        for (Assignment t : assignmentList) {
            model.insertRow(i, new Object[]{t.getTitle()});
            i++;

        }
        for (int j = assignmentList.size(); j < 25; j++) {
            model.addRow(new Object[]{" "});
        }

        courseLabel.setText(teacherController.getSelectedCourse().getCoursename());
        
        DefaultTableModel model2 = (DefaultTableModel) studentGradeTable.getModel();
        model2.getDataVector().removeAllElements();
        
        for (int j = 0; j < 25; j++) {
            model2.addRow(new Object[]{" "});
        }
        assignmentLabel.setText(" ");
    }//GEN-LAST:event_viewAssignmentsActionPerformed

    private void viewGradesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewGradesButtonActionPerformed
        int row = assignmentTable.getSelectedRow();

        ArrayList<Assignment> distinctAssignmentList = teacherController.getAssignmentsForCourse(teacherController.getSelectedCourse().getCourseID());
        if (row > distinctAssignmentList.size() - 1 || row < 0) {
            return;
        }

        //show assignments and grades for selected course
        int assignmentId = distinctAssignmentList.get(row).getAssignmentID();
        //String grades = teacherController.viewGradesForCourse(courseId);

        teacherController.getGradesForAssignment(assignmentId);
        ArrayList<Assignment> assignmentList = teacherController.getSelectedAssignmentGrades();

        DefaultTableModel model = (DefaultTableModel) studentGradeTable.getModel();
        model.getDataVector().removeAllElements();
        int i = 0;
        for (Assignment t : assignmentList) {
            model.insertRow(i, new Object[]{t.getStudent().getFirstName() + " " + t.getStudent().getLastName()
                + " (Grade: " + t.getGrade() + ")"});
            i++;

        }
        for (int j = assignmentList.size(); j < 25; j++) {
            model.addRow(new Object[]{" "});
        }
        
        assignmentLabel.setText(teacherController.getSelectedAssignmentGrades().get(0).getTitle());
    }//GEN-LAST:event_viewGradesButtonActionPerformed

    private void updateGradeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateGradeButtonActionPerformed
        int row = studentGradeTable.getSelectedRow();

        ArrayList<Assignment> assignmentList = teacherController.getSelectedAssignmentGrades();
        if (row > assignmentList.size() - 1 || row < 0) {
            return;
        }

        //show assignments and grades for selected course
        Assignment selectedAssignment = assignmentList.get(row);
        int assignmentId = selectedAssignment.getAssignmentID();
        int studentId = selectedAssignment.getStudent().getStudentID();
        String gradeString = enterGradeTextField.getText();

        try {
            int grade = Integer.parseInt(gradeString);
            AssignmentQueries.gradeAssignment(studentId, assignmentId, grade);
            assignmentList.get(row).setGrade(grade);

            DefaultTableModel model = (DefaultTableModel) studentGradeTable.getModel();
            model.getDataVector().removeAllElements();
            int i = 0;
            for (Assignment t : assignmentList) {
                model.insertRow(i, new Object[]{t.getStudent().getFirstName() + " " + t.getStudent().getLastName()
                    + " (Grade: " + t.getGrade() + ")"});
                i++;

            }
            for (int j = assignmentList.size(); j < 25; j++) {
                model.addRow(new Object[]{" "});
            }
        } catch (Exception e) {
            //do nothing if grade is entered as anything other than an int
        }
    }//GEN-LAST:event_updateGradeButtonActionPerformed

    private void addAssignmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAssignmentButtonActionPerformed
        String newAssignmentTitle = assignmentTitleTextField.getText();
        if (newAssignmentTitle.length() > 0 && newAssignmentTitle.length() < 26) {
            teacherController.createAssignment(newAssignmentTitle);

            int courseId = teacherController.getSelectedCourse().getCourseID();
            ArrayList<Assignment> assignmentList = teacherController.getAssignmentsForCourse(courseId);

            DefaultTableModel model = (DefaultTableModel) assignmentTable.getModel();
            model.getDataVector().removeAllElements();
            int i = 0;
            for (Assignment t : assignmentList) {
                model.insertRow(i, new Object[]{t.getTitle()});
                i++;

            }
            for (int j = assignmentList.size(); j < 25; j++) {
                model.addRow(new Object[]{" "});
            }
        }
    }//GEN-LAST:event_addAssignmentButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    private void init() {

    }

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
            java.util.logging.Logger.getLogger(TeacherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                TeacherView n = new TeacherView();
                n.setVisible(true);
                n.init();

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAssignmentButton;
    private javax.swing.JLabel assignmentLabel;
    private javax.swing.JTable assignmentTable;
    private javax.swing.JTextField assignmentTitleTextField;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JTextField enterGradeTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTable studentGradeTable;
    private javax.swing.JTable teacherClassTable;
    private javax.swing.JButton updateGradeButton;
    private javax.swing.JButton viewAssignments;
    private javax.swing.JButton viewGradesButton;
    // End of variables declaration//GEN-END:variables

    public static void changename(JTable j) {
        j.getColumnModel().getColumn(3).setHeaderValue("hiii");

    }

    public static void updateGrade(JTable j) {

    }

}
