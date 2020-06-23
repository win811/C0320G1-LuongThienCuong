package spring.data.jpa.customer_province.service.province_service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring.data.jpa.customer_province.model.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAllProvince ();
    Page<Province> findAllProvince (Pageable pageable);
    Page<Province> findAllProvinceByName (String name, Pageable pageable);
    Province findProvinceById (Long id);
    void saveProvince(Province province);
}
