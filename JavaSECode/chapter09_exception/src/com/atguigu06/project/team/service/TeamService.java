package com.atguigu06.project.team.service;

import com.atguigu06.project.team.domain.Architect;
import com.atguigu06.project.team.domain.Designer;
import com.atguigu06.project.team.domain.Employee;
import com.atguigu06.project.team.domain.Programmer;

/**
 * ClassName: TeamService
 * Package: com.atguigu06.project.team.service
 * Description:
 *
 * @Author 彭晨
 * @Create 2025/4/15 21:38
 * @Version 1.0
 */
public class TeamService {
    private static int counter = 1;//给memberID自动赋值的基数
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;//记录开发团队中的人数
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return team;
    }
    //添加团队成员
    public void addMember(Employee e) throws TeamException {
        if(total >= MAX_MEMBER){
            throw new TeamException("团队成员已满");
        }
        if (!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        Programmer p = (Programmer) e;
        /*
        public void addMember(Employee e){
            Programmer p = (Programmer) e;
        }
        其中Programmer继承Employee，还有一个Designer类继承Programmer，在调用addMember这个方法的时候传入的参数是Designer的实例，那么Programmer p = (Programmer) e;算向下转型还是多态呢?
        是向下转型，因为在编译的时候把e看作是Employee的，所以是向下转型
        */
        Status status = p.getStatus();
        switch (status){
            case BUSY:
                throw new TeamException("该员工已在某团队中");
            case VOCATION:
                throw new TeamException("该员工正在修建，无法添加");
        }
        boolean isExit = isExit(p);
        if(isExit){
            throw new TeamException("已经在该团队");
        }
        int numOfArc = 0,numOfDes = 0,numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect){
                numOfArc++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            }else {
                numOfPro++;
            }
        }
        if (p instanceof Architect){
            if (numOfArc >= 1){
                throw new TeamException("团队中最多一名架构师");
            }
        } else if (p instanceof Designer){
            if (numOfArc >= 2){
                throw new TeamException("团队中最多两名设计师");
            }
        } else{
            if (numOfArc >= 3){
                throw new TeamException("团队中最多三名程序员");
            }
        }
        //如果执行到了这里就代表可以被添加到团队中
        team[total++] = p;
        p.setMemberId(counter++);
        p.setStatus(Status.BUSY);
    }
    //删除团队成员
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for(;i < total;i++){

            if(team[i].getMemberId() == memberId){
                //找到了这个员工，需要调整其相关属性
                team[i].setStatus(Status.FREE);
                //员工的memberId可以不修改。
                break;
            }

        }

        //没找到
        if(i == total){
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }

        //调整数组
        for(int j = i;j < total - 1;j++){
            team[j] = team[j + 1];
        }
//        team[total-1] = null;
//        total--;
        //合并
        team[--total] = null;

    }
    private boolean isExit(Programmer p){
        for (int i = 0; i < total; i++) {
            if(team[i].getId() == p.getId()){
                return true;
            }
        }
        return false;
    }
}
