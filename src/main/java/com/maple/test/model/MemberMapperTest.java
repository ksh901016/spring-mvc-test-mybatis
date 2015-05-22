package com.maple.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.maple.test.mapper.MemberMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:servlet-context.xml"})
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
@Transactional
public class MemberMapperTest {
	
	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void testJoin() throws Exception{
		Member member = new Member();
		member.setName("hi");
		member.setEmail("asd@asd.com");
		member.setMessage("안녕하세요");
		
		mapper.insertMember(member);
		
		Member selectedMember = new Member();
		selectedMember.setName("hi");
		selectedMember.setEmail("asd@asd.com");
		
		Member actual = mapper.selectMember(selectedMember);
		
		assertNotNull(actual);
		assertEquals(member.getName(), actual.getName());
		assertEquals(member.getEmail(), actual.getEmail());
	}

}
