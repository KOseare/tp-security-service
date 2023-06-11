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

import negocio.Factura;
import negocio.IFactura;

public class DialogPagarFactura extends JDialog {
    
    private IFactura factura;
    private final JPanel contentPanel = new JPanel();
    private JTextArea detalle;
    private JButton botonPagar;
    private JButton botonCancelar;
    private JTextField monto;
    private JRadioButton efectivoRadioBoton;
    private JRadioButton TarjetaRadioBoton;
    private JRadioButton ChequeRadioBoton;
    private ButtonGroup buttonGroup;


    /**
     * Create the dialog.
     */
    public DialogPagarFactura(IFactura factura) {
        this.factura = factura;
        setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("Pagar Factura");
        setAlwaysOnTop(true);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(8, 1, 0, 0));
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel);
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            {
                JLabel nombreLabel = new JLabel("Factura: ");
                panel.add(nombreLabel);
            }
            {
                //datos de la factura
                detalle = new JTextArea();
                detalle.setEditable(false);
                detalle.setText(factura.detalle());
                panel.add(detalle);
                detalle.setColumns(10);

                // Create a JScrollPane and add the JTextArea to it
                JScrollPane scrollPane = new JScrollPane(detalle);
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                // Add the scroll pane to the content panel
                panel.add(scrollPane, BorderLayout.CENTER);
            }
        }

        efectivoRadioBoton = new JRadioButton("Efectivo");
        efectivoRadioBoton.setSelected(false);
        efectivoRadioBoton.setActionCommand("ActualizarFactura");
        contentPanel.add(efectivoRadioBoton);

        TarjetaRadioBoton = new JRadioButton("Tarjeta");
        TarjetaRadioBoton.setActionCommand("ActualizarFactura");
        contentPanel.add(TarjetaRadioBoton);
        
        ChequeRadioBoton = new JRadioButton("Cheque");
        ChequeRadioBoton.setActionCommand("ActualizarFactura");
        contentPanel.add(ChequeRadioBoton);
        


        this.buttonGroup = new ButtonGroup();
        this.buttonGroup.add(efectivoRadioBoton);
        this.buttonGroup.add(TarjetaRadioBoton);
        this.buttonGroup.add(ChequeRadioBoton);

        monto = new JTextField();
        monto.setEditable(true);

        contentPanel.add(monto, BorderLayout.SOUTH);

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                botonPagar = new JButton("Pagar");
                botonPagar.setFont(new Font("Tahoma", Font.BOLD, 11));
                botonPagar.setActionCommand("PagarFactura");
                botonPagar.setEnabled(false);
                buttonPane.add(botonPagar);
                getRootPane().setDefaultButton(botonPagar);
            }
            {
                botonCancelar = new JButton("Cancelar");
                botonCancelar.setActionCommand("CancelarFactura");
                buttonPane.add(botonCancelar);
            }
        }
    }

    public void setControlador(MainControlador c) {
        this.botonPagar.addActionListener(c);
        this.botonCancelar.addActionListener(c);
        this.efectivoRadioBoton.addActionListener(c);
        this.TarjetaRadioBoton.addActionListener(c);
        this.ChequeRadioBoton.addActionListener(c);
    }

    public String getDetalleFactura() {
        return this.detalle.getText();
    }

    public String getMonto() {
        return this.monto.getText();
    }
    
    public String getTipoMedioDePago() {
        String tipo;
        if (this.TarjetaRadioBoton.isSelected())
            tipo = "Tarjeta";
        else if (this.ChequeRadioBoton.isSelected())
            tipo = "Cheque";
        else
            tipo = "Efectivo";
        return tipo;
    }
    
    public void setFactura(IFactura f){
        this.factura = f;
        actualizarDetalle();
    }
    public void actualizarDetalle(){
        detalle.setText(factura.detalle());
        botonPagar.setEnabled(true);
    }
    public IFactura getFacturaFinal(){
        return this.factura;
    }
}
