package me.kdshim.kdd_j.kona.menu;

import me.kdshim.kdd_j.kona.menu.model.Menu;
import me.kdshim.kdd_j.kona.menu.model.MenuDto;
import me.kdshim.kdd_j.kona.tip.model.TipExtraDong;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MenuService {

    public void menuTest(){
        //TODO entity to dto를 어떻게 처리할 것인가? -> java reflection getter, setter
        //TODO 메뉴에 대한 샘플을 만들어서 실제로 어떻게 매칭되는지 확인해보자
        //우선, reflection에서의 배열을 사용하면 구현한 것 처럼 구현할 수는 있는데,현재 메뉴가 GC을 많이 치기 때문에 실제 lop로직에서도 배열정도는 사용하는지?
        //만약에 배열도 사용하지 않는 진짜 low한 로직들만 가지고 있다면 진짜 그냥 온리 세터로만 처리해야함...!실제 세터로만 해도 문제는 없다고 보임
        //그래도 나름 로직을 만들었는데 그래도 이쁘게 reflection으로 만들면 오죽좋아?

        //아무튼 이런식으로 가져와도 결국은 적지않은 크기의 배열을 가져와야 할듯...
        Menu menu = Menu.builder().placeId("MC0001").id("MN0001").priority(1).isMainMenu(false).description("TEST").imageUrl("localhost").name("이름").build();
        MenuDto dto = MenuDto.builder().priority(1).isMainMenu(false).description("FIND ME").imageUrl("1.2.3.4").name("업데이트된이름").build();

        for(Method method : MenuDto.class.getMethods()){
            if(method.getName().startsWith("get") && !method.getName().equalsIgnoreCase("getClass")){
                try {
                    System.out.println(method.invoke(this));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }


    public void saveModifiedDongTip(List<TipExtraDong> beforeDong, List<TipExtraDong> afterDong){

    }
}
