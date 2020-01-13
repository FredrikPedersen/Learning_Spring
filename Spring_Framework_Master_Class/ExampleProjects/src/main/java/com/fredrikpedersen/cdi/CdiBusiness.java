package com.fredrikpedersen.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named //CDI annotation equal to @Component
public class CdiBusiness {

    @Inject //CDI annotation equal to @Autowired
    CdiDao cdiDao;

    public CdiDao getCdiDao() {
        return cdiDao;
    }

    public void setCdiDao(CdiDao cdiDao) {
        this.cdiDao = cdiDao;
    }
}
