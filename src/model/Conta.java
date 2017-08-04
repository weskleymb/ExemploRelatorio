package model;

public class Conta {

    private int id;
    private String banco;
    private String agencia;
    private String numero;
    private String titular;

    public Conta() {}

    public Conta(int id, String banco, String agencia, String numero, String titular) {
        this.id = id;
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
    }

    public int getId() {
        return id;
    }

    public String getBanco() {
        return banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", banco=" + banco + ", agencia=" + agencia + ", numero=" + numero + ", titular=" + titular + '}';
    }
    
}
