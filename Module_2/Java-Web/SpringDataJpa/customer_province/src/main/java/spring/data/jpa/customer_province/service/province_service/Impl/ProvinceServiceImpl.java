package spring.data.jpa.customer_province.service.province_service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.data.jpa.customer_province.model.Province;
import spring.data.jpa.customer_province.repository.ProvinceRepository;
import spring.data.jpa.customer_province.service.province_service.ProvinceService;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAllProvince() {
        return provinceRepository.findAll();
    }

    @Override
    public Page<Province> findAllProvince(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public Page<Province> findAllProvinceByName(String name, Pageable pageable) {
        return provinceRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Province findProvinceById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProvince(Province province) {
        provinceRepository.save(province);
    }
}
