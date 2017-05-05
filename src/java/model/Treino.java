/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Treino {
    private String tipo;
    private String aparelhos;
    private String repeticoes;
    private String intervalo;        
    private String professor;        
    private String aluno;

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the aparelhos
     */
    public String getAparelhos() {
        return aparelhos;
    }

    /**
     * @param aparelhos the aparelhos to set
     */
    public void setAparelhos(String aparelhos) {
        this.aparelhos = aparelhos;
    }

    /**
     * @return the repeticoes
     */
    public String getRepeticoes() {
        return repeticoes;
    }

    /**
     * @param repeticoes the repeticoes to set
     */
    public void setRepeticoes(String repeticoes) {
        this.repeticoes = repeticoes;
    }

    /**
     * @return the intervalo
     */
    public String getIntervalo() {
        return intervalo;
    }

    /**
     * @param intervalo the intervalo to set
     */
    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    /**
     * @return the professor
     */
    public String getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    /**
     * @return the aluno
     */
    public String getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(String aluno) {
        this.aluno = aluno;
    }
}
