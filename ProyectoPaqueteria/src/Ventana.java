import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana {
    Lista listaPaquetes=new Lista();
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JTextField txtTracking;
    private JButton btnBuscarPaquete;
    private JComboBox cboCiudad;
    private JButton btnCiudadNombre;
    private JTextArea txtCiudadNombre;
    private JTextField txtNombre;
    private JButton btnOrdenar;

    public Ventana() {
    btnBuscarPaquete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int numero=Integer.parseInt(txtTracking.getText());
            Paquete paquete=listaPaquetes.buscarBinario(numero);
            if(paquete!=null){
                JOptionPane.showMessageDialog(null,paquete.toString());
            }else{
                JOptionPane.showMessageDialog(null, "No existe el paquete!");
            }

        }
    });
        btnCiudadNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudad=cboCiudad.getSelectedItem().toString();
                String nombre=txtNombre.getText();
                StringBuilder builder=new StringBuilder();

                ArrayList<Paquete> paquetes=listaPaquetes.buscarCiudadNombre(ciudad,nombre);
                if(paquetes.size()==0){
                    txtCiudadNombre.setText("No existen paquetes con la ciudad y nombre");
                }else{
                    for (Paquete px: paquetes){
                        builder.append(px.toString()+"\n");
                    }
                    txtCiudadNombre.setText(builder.toString());
                }
            }
        });
        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaPaquetes.ordenarBurbuja();
                StringBuilder builder=new StringBuilder();
                for(Paquete px:listaPaquetes.getListadoPaquetes()){
                    builder.append(px.toString()+"\n");
                }
                txtCiudadNombre.setText(builder.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.pack();
        frame.setSize(500,700);
        frame.setVisible(true);
    }
}
