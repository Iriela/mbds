/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iriel
 */
@Entity
@Table(name = "TESTHISTORIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testhistoric.findAll", query = "SELECT t FROM Testhistoric t")
    , @NamedQuery(name = "Testhistoric.findByIdtest", query = "SELECT t FROM Testhistoric t WHERE t.idtest = :idtest")
    , @NamedQuery(name = "Testhistoric.findByIduser", query = "SELECT t FROM Testhistoric t WHERE t.iduser = :iduser")
    , @NamedQuery(name = "Testhistoric.findByIduserAndIdTest", query = "SELECT t FROM Testhistoric t WHERE t.iduser = :iduser and t.idtest = :idtest")
    , @NamedQuery(name = "Testhistoric.findByTitle", query = "SELECT t FROM Testhistoric t WHERE t.title = :title")
    , @NamedQuery(name = "Testhistoric.findByDescription", query = "SELECT t FROM Testhistoric t WHERE t.description = :description")
    , @NamedQuery(name = "Testhistoric.findByScore", query = "SELECT t FROM Testhistoric t WHERE t.score = :score")
    , @NamedQuery(name = "Testhistoric.findByCreationdate", query = "SELECT t FROM Testhistoric t WHERE t.creationdate = :creationdate")})
public class Testhistoric implements Serializable {

    @Basic(optional = false)
    @Column(name = "IDUSER")
    private long iduser;

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "IDTEST")
    @Id
    private long idtest;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "SCORE")
    private Short score;
    @Basic(optional = false)
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;

    public Testhistoric() {
    }

    public long getIdtest() {
        return idtest;
    }

    public void setIdtest(long idtest) {
        this.idtest = idtest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }
    
}
