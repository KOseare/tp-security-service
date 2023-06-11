package presentacion;

import negocio.Factura;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class DialogFactura extends JDialog {
    private JPanel contentPanel = new JPanel();
    private JTextArea detalle;

    public DialogFactura(Factura factura) {
        setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("Factura");
        setAlwaysOnTop(true);
        setBounds(100, 100, 850, 450); // Adjust the initial size according to your needs
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        detalle = new JTextArea();
        detalle.setEditable(false);
        detalle.setText(factura.detalle());

        // Create a JScrollPane and add the JTextArea to it
        JScrollPane scrollPane = new JScrollPane(detalle);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Add the scroll pane to the content panel
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Set a preferred size for the scroll pane to allow the dialog to adjust
        scrollPane.setPreferredSize(new Dimension(800,400));
    }
}
