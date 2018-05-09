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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "WORD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Word.findAll", query = "SELECT w FROM Word w")
    , @NamedQuery(name = "Word.findByIdword", query = "SELECT w FROM Word w WHERE w.idword = :idword")
    , @NamedQuery(name = "Word.findByFrench", query = "SELECT w FROM Word w WHERE w.french = :french")
    , @NamedQuery(name = "Word.findByEnglish", query = "SELECT w FROM Word w WHERE w.english = :english")
    , @NamedQuery(name = "Word.findByListid", query = "SELECT w FROM Word w WHERE w.listid = :listid")
    , @NamedQuery(name = "Word.extendedFindListid", query = "SELECT w FROM Word w WHERE w.listid LIKE :p1 OR w.listid LIKE :p2 OR w.listid LIKE :p3")
    , @NamedQuery(name = "Word.findByIduser", query = "SELECT w FROM Word w WHERE w.iduser = :iduser")
    , @NamedQuery(name = "Word.findByCreationdate", query = "SELECT w FROM Word w WHERE w.creationdate = :creationdate")
    , @NamedQuery(name = "Word.findByModificationdate", query = "SELECT w FROM Word w WHERE w.modificationdate = :modificationdate")
    , @NamedQuery(name = "Word.findByKeyword", query = "SELECT w FROM Word w WHERE w.keyword = :keyword")})
public class Word implements Serializable {

    @Column(name = "KEYWORD")
    private String keyword;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "IDWORD")
    private Long idword;
    @Basic(optional = false)
    @Column(name = "FRENCH")
    private String french;
    @Basic(optional = false)
    @Column(name = "ENGLISH")
    private String english;
    @Column(name = "LISTID")
    private String listid;
    @Basic(optional = false)
    @Column(name = "IDUSER")
    private long iduser;
    @Basic(optional = false)
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Basic(optional = false)
    @Column(name = "MODIFICATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationdate;

    public Word() {
    }

    public Word(Long idword) {
        this.idword = idword;
    }

    public Word(Long idword, String french, String english, long iduser, Date creationdate, Date modificationdate) {
        this.idword = idword;
        this.french = french;
        this.english = english;
        this.iduser = iduser;
        this.creationdate = creationdate;
        this.modificationdate = modificationdate;
    }

    public Long getIdword() {
        return idword;
    }
    
    public void setIdword(Long idword) {
        this.idword = idword;
    }

    public String getFrench() {
        return french;
    }

    public void setFrench(String french) {
        this.french = french;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(Date modificationdate) {
        this.modificationdate = modificationdate;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idword != null ? idword.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Word)) {
            return false;
        }
        Word other = (Word) object;
        if ((this.idword == null && other.idword != null) || (this.idword != null && !this.idword.equals(other.idword))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Word[ idword=" + idword + " ]";
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
}
