package pkgfinal;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.table.*;
import javax.swing.filechooser.FileSystemView;
import java.util.Date;
import java.util.List;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Final {
    public static final String APP_TITLE = "Mirajul Islam";
    private Desktop desktop;
    private FileSystemView fileSystemView;
    private File currentFile;
    private JPanel gui;
    private JTree tree;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode tempnode;
    private JTable table;
    private JProgressBar progressBar;
    private FileTableModel fileTableModel;
    private ListSelectionListener listSelectionListener;
    private boolean cellSizesSet = false;
    private int rowIconPadding = 6;
    private JTextField path;
    private JButton go;
    private int i=0;
    
    public Component getGui(File[] all) {
        JList fileList = new JList(all);
        fileList.setCellRenderer(new FileRenderer(true));
        fileList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        fileList.setVisibleRowCount(-1);
        return new JScrollPane(fileList);
    }

    public Container getGui() {
        if (gui==null) {
            gui = new JPanel(new BorderLayout(3,3));
            gui.setBorder(new EmptyBorder(5,5,5,5));

            fileSystemView = FileSystemView.getFileSystemView();
            desktop = Desktop.getDesktop();

            JPanel detailView = new JPanel(new BorderLayout(3,3));

            table = new JTable();
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setAutoCreateRowSorter(true);
            table.setShowVerticalLines(true);

            listSelectionListener = (ListSelectionEvent lse) -> {
                try {
                    int row = table.getSelectionModel().getLeadSelectionIndex();
                    setFileDetails( ((FileTableModel)table.getModel()).getFile(row) );
                    desktop.open(currentFile);
                } catch (IOException ex) {
                    Logger.getLogger(Final.class.getName()).log(Level.SEVERE, null, ex);
                }                   
            };
            table.getSelectionModel().addListSelectionListener(listSelectionListener);
            JScrollPane tableScroll = new JScrollPane(table);
            Dimension d = tableScroll.getPreferredSize();
            tableScroll.setPreferredSize(new Dimension((int)d.getWidth(), (int)d.getHeight()/2));
            detailView.add(tableScroll, BorderLayout.CENTER);
            
            DefaultMutableTreeNode root = new DefaultMutableTreeNode();
            treeModel = new DefaultTreeModel(root);

            TreeSelectionListener treeSelectionListener = (TreeSelectionEvent tse) -> {
                DefaultMutableTreeNode node =
                        (DefaultMutableTreeNode)tse.getPath().getLastPathComponent();
                showChildren(node);
                tempnode=node;
                File file = (File) tempnode.getUserObject();
                File[] files = fileSystemView.getFiles(file, true);        
                Component c =getGui(files);
                if(i%2!=0)
                {
                    detailView.add(c, BorderLayout.CENTER);
                    gui.validate();
                    gui.repaint();
                }
                setFileDetails((File)node.getUserObject());
            };

            File[] roots = fileSystemView.getRoots();
            for (File fileSystemRoot : roots) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(fileSystemRoot);
                root.add( node );
                File[] files = fileSystemView.getFiles(fileSystemRoot, true);
                for (File file : files) {
                    if (file.isDirectory()) {
                        node.add(new DefaultMutableTreeNode(file));
                    }
                }
            }

            tree = new JTree(treeModel);
            tree.setRootVisible(false);
            tree.addTreeSelectionListener(treeSelectionListener);
            tree.setCellRenderer(new FileTreeCellRenderer());
            tree.expandRow(0);
            JScrollPane treeScroll = new JScrollPane(tree);

            tree.setVisibleRowCount(15);

            Dimension preferredSize = treeScroll.getPreferredSize();
            Dimension widePreferred = new Dimension(
                200,
                (int)preferredSize.getHeight());
            treeScroll.setPreferredSize( widePreferred );

            JPanel fileMainDetails = new JPanel(new BorderLayout(4,2));
            fileMainDetails.setBorder(new EmptyBorder(0,6,0,6));

            JPanel fileDetailsLabels = new JPanel(new GridLayout(0,1,2,2));
            fileMainDetails.add(fileDetailsLabels, BorderLayout.WEST);
            
            JPanel fileDetailsValues = new JPanel(new GridLayout(0,1,2,2));
            fileMainDetails.add(fileDetailsValues, BorderLayout.CENTER);
            
            JPanel fileDetailsButton = new JPanel(new GridLayout(0,1,2,2));
            fileMainDetails.add(fileDetailsButton, BorderLayout.EAST);
            
            fileDetailsLabels.add(new JLabel("Current Directory ",JLabel.TRAILING));
            path = new JTextField(0);
            path.setEditable(false);
            fileDetailsValues.add(path);
            go=new JButton("View");
            fileDetailsButton.add(go);
            
            go.addActionListener((ActionEvent ae) -> {
                try {
                    String str=path.getText();
                    i++;
                    File file = (File) tempnode.getUserObject();
                    File[] files = fileSystemView.getFiles(file, true);        
                    Component c2 =getGui(files);
                    if(i%2!=0)
                    {
                        detailView.remove(tableScroll);
                        detailView.add(c2, BorderLayout.CENTER);
                        gui.validate();
                        gui.repaint();
                    }
                    else
                    {
                        detailView.removeAll();
                        JPanel fileView = new JPanel(new BorderLayout(20,20));
                        fileView.add(fileMainDetails,BorderLayout.CENTER);
                        detailView.add(fileView, BorderLayout.PAGE_START);
                        detailView.add(tableScroll, BorderLayout.CENTER);
                        gui.validate();
                        gui.repaint();
                    }
                    
                } catch(Throwable t) {
                    showThrowable(t);
                }
            });
            
            JPanel fileView = new JPanel(new BorderLayout(20,20));
            fileView.add(fileMainDetails,BorderLayout.CENTER);
            detailView.add(fileView, BorderLayout.PAGE_START);
            JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                treeScroll,
                detailView);
            
            gui.add(splitPane, BorderLayout.CENTER);
            progressBar = new JProgressBar();      
        }
        return gui;
    }

    public void showRootFile() {
        tree.setSelectionInterval(0,0);
    }

    private void showThrowable(Throwable t) {
        JOptionPane.showMessageDialog(
            gui,
            t.toString(),
            t.getMessage(),
            JOptionPane.ERROR_MESSAGE
            );
        gui.repaint();
    }
    private void setTableData(final File[] files) {
        SwingUtilities.invokeLater(() -> {
            if (fileTableModel==null) {
                fileTableModel = new FileTableModel();
                table.setModel(fileTableModel);
            }
            table.getSelectionModel().removeListSelectionListener(listSelectionListener);
            fileTableModel.setFiles(files);
            table.getSelectionModel().addListSelectionListener(listSelectionListener);
            if (!cellSizesSet) {
                Icon icon = fileSystemView.getSystemIcon(files[0]);
                table.setRowHeight( icon.getIconHeight()+rowIconPadding );
                cellSizesSet = true;
            }
        });
    }
    private void showChildren(final DefaultMutableTreeNode node) {
        tree.setEnabled(false);
        progressBar.setVisible(true);
        progressBar.setIndeterminate(true);

        SwingWorker<Void, File> worker;
        worker = new SwingWorker<Void, File>() {
            @Override
            public Void doInBackground() {
                File file = (File) node.getUserObject();
                if (file.isDirectory()) {
                    File[] files = fileSystemView.getFiles(file, true);
                    if (node.isLeaf()) {
                        for (File child : files) {
                            if (child.isDirectory()) {
                                publish(child);
                            }
                        }
                    }
                    setTableData(files);
                }
                return null;
            }

            @Override
            protected void process(List<File> chunks) {
                chunks.stream().forEach((child) -> {
                    node.add(new DefaultMutableTreeNode(child));
                });
            }

            @Override
            protected void done() {
                progressBar.setIndeterminate(false);
                progressBar.setVisible(false);
                tree.setEnabled(true);
            }
        };
        worker.execute();
    }
    private void setFileDetails(File file) {
        currentFile = file;
        path.setText(file.getPath());
        JFrame f = (JFrame)gui.getTopLevelAncestor();
        if (f!=null) {
            f.setTitle(
                APP_TITLE +
                " :: " +
                fileSystemView.getSystemDisplayName(file) );
        }

        gui.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException weTried) {
            }
            
            JFrame f = new JFrame(APP_TITLE);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            Final FileBrowser = new Final();
            f.setContentPane(FileBrowser.getGui());
            f.pack();
            f.setVisible(true);
            FileBrowser.showRootFile();
        });
    }
}

/** A TableModel to hold File[]. */
class FileTableModel extends AbstractTableModel {

    private File[] files;
    private FileSystemView fileSystemView = FileSystemView.getFileSystemView();
    private String[] columns = {
        "Icon",
        "name",
        "Size",
        "Last Modified",
    };

    FileTableModel() {
        this(new File[0]);
    }

    FileTableModel(File[] files) {
        this.files = files;
    }

    @Override
    public Object getValueAt(int row, int column) {
        File file = files[row];
        switch (column) {
            case 0:
                return fileSystemView.getSystemIcon(file);
            case 1:
                return fileSystemView.getSystemDisplayName(file);
            case 2:
                return file.length();
            case 3:
                return file.lastModified();
            default:
                System.err.println("Logic Error");
        }
        return "";
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
                return ImageIcon.class;
            case 2:
                return Long.class;
            case 3:
                return Date.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
        return files.length;
    }

    public File getFile(int row) {
        return files[row];
    }

    public void setFiles(File[] files) {
        this.files = files;
        fireTableDataChanged();
    }
}

class FileTreeCellRenderer extends DefaultTreeCellRenderer {

    private final FileSystemView fileSystemView;
    private final JLabel label;
    FileTreeCellRenderer() {
        label = new JLabel();
        label.setOpaque(true);
        fileSystemView = FileSystemView.getFileSystemView();
    }

    @Override
    public Component getTreeCellRendererComponent(
        JTree tree,
        Object value,
        boolean selected,
        boolean expanded,
        boolean leaf,
        int row,
        boolean hasFocus) {

        DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
        File file = (File)node.getUserObject();
        label.setIcon(fileSystemView.getSystemIcon(file));
        label.setText(fileSystemView.getSystemDisplayName(file));
        label.setToolTipText(file.getPath());

        if (selected) {
            label.setBackground(backgroundSelectionColor);
            label.setForeground(textSelectionColor);
        } else {
            label.setBackground(backgroundNonSelectionColor);
            label.setForeground(textNonSelectionColor);
        }

        return label;
    }   
}

class TextFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        String name = file.getName().toLowerCase();
        return name.length()<20;
    }
}

class FileRenderer extends DefaultListCellRenderer {

    private final boolean pad;
    private final Border padBorder = new EmptyBorder(3,3,3,3);

    FileRenderer(boolean pad) {
        this.pad = pad;
    }

    @Override
    public Component getListCellRendererComponent(
        JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus) {

        Component c = super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        JLabel l = (JLabel)c;
        File f = (File)value;
        l.setText(f.getName());
        l.setIcon(FileSystemView.getFileSystemView().getSystemIcon(f));
        if (pad) {
            l.setBorder(padBorder);
        }
        return l;
    }
}