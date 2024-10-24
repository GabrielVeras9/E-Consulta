package br.com.consulta.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USUARIOS", schema = "DFTRANS")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "USERNAME", length = 30, nullable = false)
    private String username;

    @Column(name = "DS_SENHA", length = 30, nullable = false)
    private String senha;

    @Column(name = "ST_ATIVO", length = 1)
    private String ativo;

    @Column(name = "DT_ULTIMO_ACESSO")
    @Temporal(TemporalType.DATE)
    private Date ultimoAcesso;

    @Column(name = "QTD_ACESSO_NEGADO", precision = 1)
    private Integer qtdAcessoNegado;

    @Column(name = "ST_TROCA_SENHA", length = 1)
    private String trocaSenha;

    @Column(name = "CS_TIPO_USUARIO", length = 1)
    private String tipoUsuario;

    @Column(name = "NM_USUARIO", length = 200)
    private String nomeUsuario;

    @Column(name = "NR_CPF_USUARIO", length = 11)
    private String cpfUsuario;

    @Column(name = "TX_EMAIL_USUARIO", length = 50)
    private String emailUsuario;

    @Column(name = "NR_TELEFONE_USUARIO", precision = 13)
    private Long telefoneUsuario;

    @Column(name = "NR_CELULAR_USUARIO", precision = 13)
    private Long celularUsuario;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public Integer getQtdAcessoNegado() {
		return qtdAcessoNegado;
	}

	public void setQtdAcessoNegado(Integer qtdAcessoNegado) {
		this.qtdAcessoNegado = qtdAcessoNegado;
	}

	public String getTrocaSenha() {
		return trocaSenha;
	}

	public void setTrocaSenha(String trocaSenha) {
		this.trocaSenha = trocaSenha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public Long getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(Long telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	public Long getCelularUsuario() {
		return celularUsuario;
	}

	public void setCelularUsuario(Long celularUsuario) {
		this.celularUsuario = celularUsuario;
	}
    
}