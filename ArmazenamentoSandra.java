public class ArmazenamentoSandra {
    String paciente;
    int codigo_convenio;
    double valor;
    
    public ArmazenamentoSandra (String paciente, int codigo_convenio, double valor){
        this.paciente = paciente;
        this.codigo_convenio = codigo_convenio;
        this.valor = valor;
    }

    public String getPaciente() {
		return this.paciente;
	}

	public int getCodigo_convenio() {
		return this.codigo_convenio;
	}

	public double getValor() {
		return this.valor;
	}   
	}
    
