package presentacion;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class DialogException extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JButton botonAceptar;



    DialogException(String string) {

        setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("Error");
        setAlwaysOnTop(true);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(8, 1, 0, 0));
        {
            JLabel nombreLabel = new JLabel(string);
            contentPanel.add(nombreLabel);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                botonAceptar = new JButton("Aceptar");
                botonAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
                botonAceptar.setActionCommand("AceptarMensaje");
                botonAceptar.setEnabled(true);
                buttonPane.add(botonAceptar);
                getRootPane().setDefaultButton(botonAceptar);
            }

        }


    }
    public void setControlador (MainControlador c) {
        this.botonAceptar.addActionListener(c);
    }


}