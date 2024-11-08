package gamificaciondeportiva;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import gamificaciondeportiva.ActividadDeportiva.TipoDeporte;

// Clase principal con interfaz gráfica
public class MainGamificacionDeportiva extends JFrame {
	private static final long serialVersionUID = 7373312922578784859L;
	private SistemaGamificacion sistema;
	private Usuario usuarioActual;
	private JTabbedPane tabbedPane;
	private JPanel panelPerfil;
	private JPanel panelActividades;
	private JPanel panelLogros;
	private JPanel panelDesafios;
	private JPanel panelCompetencias;

	public MainGamificacionDeportiva() {
		sistema = new SistemaGamificacion();
		// Crear usuario de prueba
		usuarioActual = new Usuario("U001", "Usuario Prueba");
		sistema.getUsuarios().add(usuarioActual);

		configurarVentana();
		inicializarComponentes();
	}

	private void configurarVentana() {
		setTitle("Gamificación Deportiva");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
	}

	private void inicializarComponentes() {
		// Crear panel de pestañas
		tabbedPane = new JTabbedPane();

		// Inicializar paneles
		inicializarPanelPerfil();
		inicializarPanelActividades();
		inicializarPanelLogros();
		inicializarPanelDesafios();
		inicializarPanelCompetencias();

		// Agregar pestañas
		tabbedPane.addTab("Perfil", new ImageIcon(), panelPerfil, "Perfil de usuario");
		tabbedPane.addTab("Actividades", new ImageIcon(), panelActividades, "Registro de actividades");
		tabbedPane.addTab("Logros", new ImageIcon(), panelLogros, "Logros disponibles");
		tabbedPane.addTab("Desafíos", new ImageIcon(), panelDesafios, "Desafíos activos");
		tabbedPane.addTab("Competencias", new ImageIcon(), panelCompetencias, "Competencias disponibles");

		add(tabbedPane, BorderLayout.CENTER);
	}

	private void inicializarPanelPerfil() {
		panelPerfil = new JPanel(new BorderLayout(10, 10));
		panelPerfil.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Panel de información básica
		JPanel infoPerfil = new JPanel(new GridLayout(4, 2, 5, 5));
		infoPerfil.add(new JLabel("ID:"));
		infoPerfil.add(new JLabel(usuarioActual.getId()));
		infoPerfil.add(new JLabel("Nombre:"));
		infoPerfil.add(new JLabel(usuarioActual.getNombre()));
		infoPerfil.add(new JLabel("Nivel:"));
		infoPerfil.add(new JLabel(String.valueOf(usuarioActual.getNivel())));
		infoPerfil.add(new JLabel("Puntos Totales:"));
		infoPerfil.add(new JLabel(String.valueOf(usuarioActual.getPuntosTotales())));

		// Barra de progreso de experiencia
		JProgressBar progressExperiencia = new JProgressBar(0, 1000);
		progressExperiencia.setValue(usuarioActual.getExperiencia() % 1000);
		progressExperiencia.setStringPainted(true);
		progressExperiencia.setString("Experiencia: " + usuarioActual.getExperiencia() % 1000 + "/1000");

		panelPerfil.add(infoPerfil, BorderLayout.NORTH);
		panelPerfil.add(progressExperiencia, BorderLayout.CENTER);
	}

	private void inicializarPanelActividades() {
		panelActividades = new JPanel(new BorderLayout(10, 10));
		panelActividades.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Panel de formulario
		JPanel formulario = new JPanel(new GridLayout(5, 2, 5, 5));

		JComboBox<TipoDeporte> comboDeporte = new JComboBox<>(TipoDeporte.values());
		JTextField txtDuracion = new JTextField();
		JTextField txtDistancia = new JTextField();
		JButton btnRegistrar = new JButton("Registrar Actividad");

		formulario.add(new JLabel("Tipo de Deporte:"));
		formulario.add(comboDeporte);
		formulario.add(new JLabel("Duración (minutos):"));
		formulario.add(txtDuracion);
		formulario.add(new JLabel("Distancia (km):"));
		formulario.add(txtDistancia);
		formulario.add(new JLabel(""));
		formulario.add(btnRegistrar);

		// Tabla de actividades recientes
		String[] columnas = { "Fecha", "Deporte", "Duración", "Distancia", "Calorías" };
		DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
		JTable tablaActividades = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaActividades);

		btnRegistrar.addActionListener(e -> {
			try {
				TipoDeporte tipo = (TipoDeporte) comboDeporte.getSelectedItem();
				int duracion = Integer.parseInt(txtDuracion.getText());
				double distancia = Double.parseDouble(txtDistancia.getText());

				ActividadDeportiva actividad = new ActividadDeportiva("A" + System.currentTimeMillis(), tipo, duracion,
						distancia, usuarioActual);

				sistema.registrarActividad(actividad);

				// Actualizar tabla
				modeloTabla.addRow(
						new Object[] { actividad.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
								tipo, duracion + " min", distancia + " km", actividad.getCaloriasQuemadas() });

				// Limpiar campos
				txtDuracion.setText("");
				txtDistancia.setText("");
				JOptionPane.showMessageDialog(this, "Actividad registrada con éxito!");
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		});

		panelActividades.add(formulario, BorderLayout.NORTH);
		panelActividades.add(scrollTabla, BorderLayout.CENTER);
	}

	private void inicializarPanelLogros() {
		panelLogros = new JPanel(new BorderLayout(10, 10));
		panelLogros.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Lista de logros
		DefaultListModel<String> modeloLista = new DefaultListModel<>();
		for (Logro logro : sistema.getLogrosDisponibles()) {
			modeloLista.addElement(logro.getNombre() + " - " + logro.getDescripcion());
		}
		JList<String> listaLogros = new JList<>(modeloLista);
		listaLogros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollLogros = new JScrollPane(listaLogros);
		panelLogros.add(scrollLogros, BorderLayout.CENTER);
	}

	private void inicializarPanelDesafios() {
		panelDesafios = new JPanel(new BorderLayout(10, 10));
		panelDesafios.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Panel de desafíos activos
		JPanel desafiosActivos = new JPanel(new GridLayout(0, 1, 5, 5));
		for (Desafio desafio : sistema.getDesafiosActivos()) {
			JPanel panelDesafio = new JPanel(new BorderLayout());
			panelDesafio.setBorder(BorderFactory.createTitledBorder(desafio.getNombre()));

			JLabel lblDescripcion = new JLabel(desafio.getDescripcion());
			JButton btnUnirse = new JButton("Unirse al desafío");

			btnUnirse.addActionListener(e -> {
				desafio.unirseAlDesafio(usuarioActual);
				btnUnirse.setEnabled(false);
				btnUnirse.setText("Unido");
			});

			panelDesafio.add(lblDescripcion, BorderLayout.CENTER);
			panelDesafio.add(btnUnirse, BorderLayout.EAST);

			desafiosActivos.add(panelDesafio);
		}

		JScrollPane scrollDesafios = new JScrollPane(desafiosActivos);
		panelDesafios.add(scrollDesafios, BorderLayout.CENTER);
	}

	private void inicializarPanelCompetencias() {
		panelCompetencias = new JPanel(new BorderLayout(10, 10));
		panelCompetencias.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Tabla de competencias
		String[] columnas = { "Nombre", "Deporte", "Fecha Inicio", "Fecha Fin", "Estado", "Acción" };
		DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = -2730975240082522044L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 5; // Solo la columna de acción es editable
			}
		};

		JTable tablaCompetencias = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaCompetencias);

		// Agregar algunas competencias de ejemplo
		for (Competencia competencia : sistema.getCompetencias()) {
			modeloTabla.addRow(new Object[] { competencia.getNombre(), competencia.getTipoDeporte(),
					competencia.getFechaInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					competencia.getFechaFin().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					competencia.getEstado(), "Inscribirse" });
		}

		panelCompetencias.add(scrollTabla, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		try {
			// Establecer el look and feel del sistema
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(() -> {
			MainGamificacionDeportiva ventana = new MainGamificacionDeportiva();
			ventana.setVisible(true);
		});
	}
}