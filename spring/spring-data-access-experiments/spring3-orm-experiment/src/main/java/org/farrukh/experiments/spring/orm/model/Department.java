package org.farrukh.experiments.spring.orm.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {
    
    @Id
    @Column(name="DEPARTMENT_ID")
    private BigDecimal id;
    
    @Column(name="DEPARTMENT_NAME")
    private String name;
    
    @Column(name = "MANAGER_ID")
    @OneToMany(mappedBy = "departament")
    private List<Employee> managers;
    
    @Column(name="LOCATION_ID")
    @OneToMany
    @JoinColumn(name="LOCATION_ID")
    private List<Location> locations;
    

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getManagers() {
        return managers;
    }

    public void setManagers(List<Employee> managers) {
        this.managers = managers;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Department))
            return false;
        Department other = (Department) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Department [id=")
               .append(id)
               .append(", name=")
               .append(name)
               .append(", managers=")
               .append(managers)
               .append(", locations=")
               .append(locations)
               .append("]");
        return builder.toString();
    }
    
}
