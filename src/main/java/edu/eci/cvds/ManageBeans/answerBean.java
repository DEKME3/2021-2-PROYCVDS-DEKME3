package edu.eci.cvds.ManageBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import edu.eci.cvds.entities.Respuesta;
import edu.eci.cvds.services.client.MyBatisPrueba;


@SuppressWarnings("deprecation")
@SessionScoped
@ManagedBean(name = "answerBean")
public class answerBean {

    public int updateId;
    public String name;
    public String comments_;
    public Date creationDate;
    public int Offer;
    public int need;
    public List<Respuesta> answers = new ArrayList<>();

    public answerBean() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnswers(List<Respuesta> answers) {
        this.answers = answers;
    }

    public void setComments(String comments_) {
        this.comments_ = comments_;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }

    public String getComments_() {
        return comments_;
    }

    public int getOffer() {
        return Offer;
    }

    public int getneed() {
        return need;
    }

    public List<Respuesta> getAnswers() {
        return answers;
    }

    public int getUpdateId() {
        return updateId;
    }

    public void insertAnswer(){
        Respuesta newAnswer = new Respuesta(name, comments_, new Date(), Offer, need);
        MyBatisPrueba.insertarRespuesta(newAnswer);
        answers.add(newAnswer);
    }
}
