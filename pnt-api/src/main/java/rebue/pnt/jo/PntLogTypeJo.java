/*
 * The MIT License
 *
 * Copyright 2018 zbz.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package rebue.pnt.jo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zbz
 */
@Entity
@Table(name = "PNT_LOG_TYPE", catalog = "pnt", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PntLogType.findAll", query = "SELECT p FROM PntLogType p"),
    @NamedQuery(name = "PntLogType.findById", query = "SELECT p FROM PntLogType p WHERE p.id = :id"),
    @NamedQuery(name = "PntLogType.findByTypeName", query = "SELECT p FROM PntLogType p WHERE p.typeName = :typeName"),
    @NamedQuery(name = "PntLogType.findByRemark", query = "SELECT p FROM PntLogType p WHERE p.remark = :remark")})
public class PntLogTypeJo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String id;
    @Basic(optional = false)
    @Column(name = "TYPE_NAME", nullable = false, length = 30)
    private String typeName;
    @Column(length = 120)
    private String remark;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logTypeId")
    private List<PntLogJo> pntLogList;

    public PntLogTypeJo() {
    }

    public PntLogTypeJo(String id) {
        this.id = id;
    }

    public PntLogTypeJo(String id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @XmlTransient
    public List<PntLogJo> getPntLogList() {
        return pntLogList;
    }

    public void setPntLogList(List<PntLogJo> pntLogList) {
        this.pntLogList = pntLogList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PntLogTypeJo)) {
            return false;
        }
        PntLogTypeJo other = (PntLogTypeJo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rebue.pnt.jo.PntLogType[ id=" + id + " ]";
    }
    
}
