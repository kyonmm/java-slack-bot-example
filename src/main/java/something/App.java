/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package something;

import org.riversun.slacklet.Slacklet;
import org.riversun.slacklet.SlackletRequest;
import org.riversun.slacklet.SlackletResponse;
import org.riversun.slacklet.SlackletService;
import org.riversun.xternal.simpleslackapi.SlackChannel;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        String botToken ="xoxb-854564613383-853322617664-IqwPL7VwLOPF4NKzcTYfHlIB" ;

        SlackletService slackService = new SlackletService(botToken);

        // slackletを追加する
        slackService.addSlacklet(new Slacklet() {

            @Override
            public void onMessagePosted(SlackletRequest req, SlackletResponse resp) {
                // メッセージがユーザーからポストされた

                // メッセージがポストされたチャンネルを取得する
                SlackChannel channel = req.getChannel();

                if ("example".equals(channel.getName())) {
                    // #randomチャンネルだった場合

                    // メッセージ本文を取得
                    String content = req.getContent();

                    // メッセージがポストされたチャンネルに対して、BOTからメッセージを送る
                    resp.reply("「" + content + "」て言いましたね。");

                }

            }
        });

        // slackletserviceを開始(slackに接続)
        slackService.start();
    }
}
