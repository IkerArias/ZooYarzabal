package Ventanas;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class VentanaLimpieza extends JFrame {
    protected JFrame vActual, vAnterior;
    protected JButton btnVolver, btnComenzar, btnFinalizar, btnAnadir, btnAgregar;
    protected JPanel pSur;
    protected JList<String> listaTareas;
    protected DefaultListModel<String> listModel;
    protected JTextField txtNuevaTarea;
    
    public VentanaLimpieza(JFrame va) {
        super();
        vActual = this;
        vAnterior = va;
        setTitle("Ventana de Limpieza");
        setBounds(500, 300, 700, 400); // Ajuste el tamaño de la ventana según sea necesario
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear lista de tareas
        listModel = new DefaultListModel<>();
        listModel.addElement("Limpiar oficina principal");
        listModel.addElement("Vaciar papeleras");
        listModel.addElement("Limpiar baños");
        listModel.addElement("Lavar ventanas");

        listaTareas = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaTareas);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Botones y acciones
        btnComenzar = new JButton(new ComenzarTareaAction());
        btnFinalizar = new JButton(new FinalizarTareaAction());
        btnAnadir = new JButton(new AgregarTareaAction());
        btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener((e) -> {
            vAnterior.setVisible(true);
            vActual.dispose();
        });
        

        // Panel con botones
        pSur = new JPanel();
        getContentPane().add(pSur, BorderLayout.SOUTH);
        pSur.add(btnComenzar);
        pSur.add(btnFinalizar);
        pSur.add(btnVolver);
        
        JPanel pNorte = new JPanel();
        getContentPane().add(pNorte, BorderLayout.NORTH);
        pNorte.add(txtNuevaTarea);
        pNorte.add(btnAgregar);

        setVisible(true);
    }

    // Acción para agregar una tarea
    private class AgregarTareaAction extends AbstractAction {
        public AgregarTareaAction() {
            super("Agregar Tarea");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nuevaTarea = txtNuevaTarea.getText().trim();
            if (!nuevaTarea.isEmpty()) {
                listModel.addElement(nuevaTarea);
                txtNuevaTarea.setText(""); 
            }
        }
    }
    
    // Acción para comenzar una tarea
    private class ComenzarTareaAction extends AbstractAction {
        public ComenzarTareaAction() {
            super("Comenzar Tarea");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = listaTareas.getSelectedIndex();
            if (selectedIndex != -1) {
                
                String tareaSeleccionada = listModel.getElementAt(selectedIndex);
                System.out.println("Comenzar tarea: " + tareaSeleccionada);
            }
        }
    }

    // Acción para finalizar una tarea
    private class FinalizarTareaAction extends AbstractAction {
        public FinalizarTareaAction() {
            super("Finalizar Tarea");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = listaTareas.getSelectedIndex();
            if (selectedIndex != -1) {
                // Aquí puedes implementar la lógica para finalizar la tarea seleccionada
                String tareaSeleccionada = listModel.getElementAt(selectedIndex);
                System.out.println("Finalizar tarea: " + tareaSeleccionada);
            }
        }
    }
}




