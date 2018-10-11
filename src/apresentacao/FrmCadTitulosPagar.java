/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidade.CentroCusto;
import entidade.Fornecedor;
import entidade.TitulosPagar;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import negocio.NCentroCusto;
import negocio.NFornecedor;
import negocio.NTitulosPagar;

public class FrmCadTitulosPagar extends javax.swing.JInternalFrame {

    JDesktopPane pnlPrincipal;

    public FrmCadTitulosPagar() {
        initComponents();
        carregarComboFornecedor();
        carregarComboCC();
    }

    public FrmCadTitulosPagar(JDesktopPane pnlPrincipal) {
        this();
        this.pnlPrincipal = pnlPrincipal;
    }

    public FrmCadTitulosPagar(JDesktopPane pnlPrincipal, String codigo) {

        this();
        this.pnlPrincipal = pnlPrincipal;

        //preencher a tela
        try {

            NTitulosPagar negocio = new NTitulosPagar();
            TitulosPagar tp = negocio.consultar(Integer.parseInt(codigo));
            txtCodigo.setText(tp.getId() + "");
            txtDtVencimento.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
            txtValor.setText(String.valueOf(tp.getValor()));
            txtJuros.setText(String.valueOf(tp.getJuros()));
            txtDesconto.setText(String.valueOf(tp.getDesconto()));

            cmbFornecedor.removeAllItems();
            cmbCentroCusto.removeAllItems();
           // cmbSituacao.removeAllItems();
            carregarComboFornecedor();

            btnExcluir.setEnabled(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
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

        txtDtVencimento = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbFornecedor = new javax.swing.JComboBox();
        cmbCentroCusto = new javax.swing.JComboBox();
        txtValor = new javax.swing.JTextField();
        txtJuros = new javax.swing.JTextField();
        cmbSituacao = new javax.swing.JComboBox<>();
        txtDesconto = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        txtDtVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDtVencimentoActionPerformed(evt);
            }
        });

        jLabel1.setText("Data Vencimento");

        jLabel2.setText("Valor");

        jLabel3.setText("Juros");

        jLabel4.setText("Desconto");

        jLabel5.setText("Situação");

        jLabel6.setText("Centro de Custo");

        jLabel7.setText("Fornecedor");

        cmbFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbFornecedorMousePressed(evt);
            }
        });
        cmbFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFornecedorActionPerformed(evt);
            }
        });

        cmbSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Baixado" }));
        cmbSituacao.setEnabled(false);
        cmbSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSituacaoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel8.setText("Codigo");

        txtCodigo.setEnabled(false);

        jButton1.setText("Pesquisa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvar)
                .addGap(142, 142, 142)
                .addComponent(btnLimpar)
                .addGap(38, 38, 38)
                .addComponent(btnFechar)
                .addGap(0, 60, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(44, 44, 44)
                        .addComponent(cmbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExcluir)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmbSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDesconto)
                            .addComponent(cmbCentroCusto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDtVencimento)
                            .addComponent(txtValor)
                            .addComponent(txtJuros)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtJuros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbCentroCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar)
                    .addComponent(btnFechar))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDtVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDtVencimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDtVencimentoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {

            if (txtDtVencimento.getText().isEmpty()) {
                throw new Exception("Informe a data de vencimento");
            }
            if (txtValor.getText().isEmpty()) {
                throw new Exception("Iforme um valor");
            }
            if (txtJuros.getText().isEmpty()) {
                throw new Exception("Iforme um valor de juros");
            }
            if (txtDesconto.getText().isEmpty()) {
                throw new Exception("Iforme um valor de desconto");
            }
            if (cmbCentroCusto.getSelectedItem().equals("")) {
                throw new Exception("Informe o centro de custo");
            }
            if (cmbFornecedor.getSelectedItem().equals("")) {
                throw new Exception("Informe o fornecedor");
            }
            if (cmbSituacao.getSelectedItem().equals("")) {
                throw new Exception("Informe a situação do centro de custo");
            }

            TitulosPagar tp = new TitulosPagar();

            if (!txtCodigo.getText().isEmpty()) {
                tp.setId(Integer.parseInt(txtCodigo.getText()));
            }

            String sit = (String) cmbSituacao.getSelectedItem();
            txtDtVencimento.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
            txtValor.setText(String.valueOf(tp.getValor()));
            txtJuros.setText(String.valueOf(tp.getJuros()));
            txtDesconto.setText(String.valueOf(tp.getDesconto()));
            
            //tp.setStatus(sit.equals("Ativo")?1:0);

            NTitulosPagar negocio = new NTitulosPagar();

            negocio.salvar(tp);

            JOptionPane.showMessageDialog(null, "Operação efetuada com sucesso!");

            limpar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            int resposta = JOptionPane.showConfirmDialog(null,
                    "Confirma a exlusão do titulo?", "AppContas a Pagar",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {

                NTitulosPagar negocio = new NTitulosPagar();

                negocio.excluir(Integer.parseInt(txtCodigo.getText()));
                JOptionPane.showMessageDialog(null, "Exclusão efetuado com Sucesso");
                limpar();
                btnExcluir.enable(false);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            FrmPesTitulosPagar janela = new FrmPesTitulosPagar(pnlPrincipal);
            pnlPrincipal.add(janela);
            janela.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFornecedorActionPerformed

    private void cmbSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSituacaoActionPerformed

    private void cmbFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbFornecedorMousePressed
      
    }//GEN-LAST:event_cmbFornecedorMousePressed
    private void limpar() {
        txtCodigo.setText("");
        txtDtVencimento.setText("");
        txtValor.setText("");
        txtJuros.setText("");
        txtDesconto.setText("");
        txtCodigo.setText("");

        btnExcluir.setEnabled(false);
    }

    /*
    private void carregarCombo() {
        try {
            cmbSituacao.addItem("");
            cmbSituacao.addItem("Ativo");
            cmbSituacao.addItem("Inativo");

            cmbFornecedor.addItem("");
            cmbFornecedor.addItem("Nome");
            cmbFornecedor.addItem("Cpf");
            cmbFornecedor.addItem("Endereco");
            cmbFornecedor.addItem("Telefone");
            cmbFornecedor.addItem("Email");
            cmbFornecedor.addItem("Ie");

            cmbCentroCusto.addItem("");
            cmbCentroCusto.addItem("Descricao");
            cmbCentroCusto.addItem("Ativo");
            cmbCentroCusto.addItem("Inativo");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
     */
    private void carregarComboFornecedor() {
        try {

            Fornecedor item0 = new Fornecedor(0, "Selecione...");
            cmbFornecedor.addItem(item0);

            for (Fornecedor item : new NFornecedor().listar()) {
                cmbFornecedor.addItem(item);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbCentroCusto;
    private javax.swing.JComboBox cmbFornecedor;
    private javax.swing.JComboBox<String> cmbSituacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JFormattedTextField txtDtVencimento;
    private javax.swing.JTextField txtJuros;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

    private void carregarComboCC() {
    try {

            CentroCusto item0 = new CentroCusto(0, "Selecione...");
            cmbCentroCusto.addItem(item0);

            for (CentroCusto item : new NCentroCusto().listar()) {
                cmbCentroCusto.addItem(item);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
    }

}
