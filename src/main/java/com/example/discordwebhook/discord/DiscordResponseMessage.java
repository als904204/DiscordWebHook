package com.example.discordwebhook.discord;

import com.example.discordwebhook.discord.DiscordWebHook.EmbedObject;
import java.awt.Color;
import java.io.IOException;

public class DiscordResponseMessage {

    private static final String discordUrl = "test";


    public static void main(String[] args) {
        sendMessage();
        sendDetailMessage();
    }
    public static void sendMessage(){
        DiscordWebHook webhook = new DiscordWebHook(discordUrl);

        webhook.setUsername("디스코드 봇");
        webhook.setAvatarUrl("https://i.imgur.com/oBPXx0D.png");
        webhook.addEmbed(
            new EmbedObject()
                .setTitle("title")
                .setDescription("description")
                .setColor(Color.RED)
                .addField("Field1", "value1", false)
                .addField("Field1", "value2", true)
        );
        try {
            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sendDetailMessage() {
        try {
            DiscordWebHook webhook = new DiscordWebHook(discordUrl);

            webhook.setUsername("디스코드 봇2");

            // Embed 객체 생성
            DiscordWebHook.EmbedObject embed = new DiscordWebHook.EmbedObject()
                .setAuthor("MINU", "https://velog.io/@minu1117", "https://i.imgur.com/oBPXx0D.png") // 작성자,링크,이미지
                .setTitle("제목")
                .setDescription("설명 부분 [Markdown](https://velog.io/@minu1117/)!") // []를 사용하면 링크 설정 가능
                .setColor(Color.GREEN)
                .setFooter("여기는 footer 입니다 ", "https://i.imgur.com/Hv0xNBm.jpeg") //  푸터
                .setThumbnail("https://i.imgur.com/oBPXx0D.png") //  썸네일 이미지
                .setImage("https://i.imgur.com/8nLFCVP.png") //  메인 이미지
                .addField("인라인필드 true (Inline)", "인라인필드 true value (Inline)", true) // 인라인 필드 추가
                .addField("Field Name", "Field Value", false); // 일반 필드 추가

            // Embed 추가
            webhook.addEmbed(embed);

            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
