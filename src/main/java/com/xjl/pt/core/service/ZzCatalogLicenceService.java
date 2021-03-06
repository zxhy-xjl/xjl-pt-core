package com.xjl.pt.core.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xjl.pt.core.service.XJLService;
import com.xjl.pt.core.domain.XJLDomain;
import com.xjl.pt.core.domain.ZzCatalogLicence;
import com.xjl.pt.core.mapper.ZzCatalogLicenceMapper;

/**
 * 个人证照目录分类
 * @author ServiceCoderTools 陶杰
 *
 */
@Service
public class ZzCatalogLicenceService extends XJLService {
	@Autowired
	private ZzCatalogLicenceMapper zzCatalogLicenceMapper;
	@Override
	public void _add(XJLDomain domain) {
		this.zzCatalogLicenceMapper.insert(domain);
	}
	
	public List<ZzCatalogLicence> query(String search, int page, int pageSize) {
		if (StringUtils.isEmpty(search)){
			PageHelper.startPage(page, pageSize);
			return this.zzCatalogLicenceMapper.selectAll();
		} else {
			throw new RuntimeException("带search值的查询还没有实现");
		}
	}
	@Override
	public void _resetNewId(XJLDomain domain) {
	}

	@Override
	public void _delete(XJLDomain domain) {
		// TODO Auto-generated method stub
		this.zzCatalogLicenceMapper.delete(domain);
	}

	@Override
	public void _modify(XJLDomain domain) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 通过catalogId查出目录中的证照记录
	 * @param catalogId
	 * @return
	 */
	public List<ZzCatalogLicence> queryByCatalogId(String catalogId){
		return this.zzCatalogLicenceMapper.selectByCatalogId(catalogId);
	}
	
	/**
	 * 通过catalogid和licenceid查出目录中的证照记录
	 * 
	 */
	public List<ZzCatalogLicence> queryByCatalogIdAndLicenceId(String catalogId,String licenceId){
		return this.zzCatalogLicenceMapper.selectByCatalogIdAndLicenceId(catalogId, licenceId);
	}
	/**
	 * 通过licanceid获取目录中的某条证照记录
	 */
	public List<ZzCatalogLicence> queryByLicenceId(String licenceId){
		return this.zzCatalogLicenceMapper.selectByLicenceId(licenceId);
	}
}
