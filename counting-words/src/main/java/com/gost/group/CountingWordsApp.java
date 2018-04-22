package com.gost.group;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class CountingWordsApp {

    private static final String FILE_NAME = "D:\\KUS_tbm.xml";
    private static final String DEFAULT_TEXT_FOR_TEXT = "От Смоленска войска продолжали отступать. Неприятель шел вслед за ними. 10-го августа полк, которым командовал князь Андрей, проходил по большой дороге, мимо проспекта, ведущего в Лысые Горы. Жара и засуха стояли более трех недель. Каждый день по небу ходили курчавые облака, изредка заслоняя солнце; но к вечеру опять расчищало, и солнце садилось в буровато-красную мглу. Только сильная роса ночью освежала землю. Остававшиеся на корню хлеба сгорали и высыпались. Болота пересохли. Скотина ревела от голода, не находя корма по сожженным солнцем лугам. Только по ночам и в лесах, пока еще держалась роса, была прохлада. Но по дороге, по большой дороге, по которой шли войска, даже и ночью, даже и по лесам, не было этой прохлады. Роса не заметна была на песочной пыли дороги, встолченной больше чем на четверть аршина. Как только рассветало, начиналось движение. Обозы, артиллерия беззвучно шли по ступицу, а пехота по щиколку в мягкой, душной, не остывшей за ночь, жаркой пыли. Одна часть этой песочной пыли месилась ногами и колесами, другая поднималась и стояла облаком над войском, влипая в глаза, в волоса, в уши, в ноздри и, главное, в легкие людям и животным, двигавшимся по этой дороге. Чем выше поднималось солнце, тем выше поднималось облако пыли, и сквозь эту тонкую, жаркую пыль на солнце, не закрытое облаками, можно было смотреть простым глазом. Солнце представлялось большим багровым шаром. Ветра не было, и люди задыхались в этой неподвижной атмосфере. Люди шли, обвязавши носы и рты платками. Приходя к деревне, все бросалось к колодцам. Дрались за воду и выпивали ее до грязи.";

    public static void main(String[] args) throws IOException {
        String text = null;
        if(args!=null && args.length >= 1)  {
            String filePath = args[0];
            StringBuilder builder = new StringBuilder();
            Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(builder::append);
            text = builder.toString();
        } else {
            text = DEFAULT_TEXT_FOR_TEXT;
        }

        CalculationWord calculationWord = new CalculationWordByStream();
        Map<String, Integer> map = calculationWord.countingWordsAndSortByCount(text);
        System.out.println(map);
    }
}

