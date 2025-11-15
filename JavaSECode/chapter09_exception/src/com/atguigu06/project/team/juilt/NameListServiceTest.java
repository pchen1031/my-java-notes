package com.atguigu06.project.team.juilt;

import com.atguigu06.project.team.domain.Designer;
import com.atguigu06.project.team.domain.Employee;
import com.atguigu06.project.team.service.NameListService;
import com.atguigu06.project.team.service.TeamException;
import org.junit.Test;


/**
 * ClassName: NameListServiceTest
 * Package: com.atguigu06.project.team.juilt
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/15 17:07
 * @Version 1.0
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameListService nameListService = new NameListService();
        Employee[] employee = nameListService.getAllEmployees();
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i]);
        }
    }
    @Test
    public void testGetEmployees(){
        try {
            NameListService nameListService = new NameListService();
            Employee employee = nameListService.getEmployee(100);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }

    }
    @Test
    public void test3(){
        Designer d = new Designer();
        System.out.println(d.getStatus());
    }


    
}
