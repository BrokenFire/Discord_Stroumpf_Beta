package net.Broken.RestApi.Commands;

import net.Broken.Commands.Music;
import net.Broken.RestApi.CommandInterface;
import net.Broken.RestApi.Data.CommandPostData;
import net.Broken.RestApi.Data.CommandResponseData;
import net.Broken.audio.AudioM;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Next Track RestApi command
 */
public class Next implements CommandInterface {
    @Override
    public ResponseEntity<CommandResponseData> action(CommandPostData data, User user, Guild guild) {
        AudioM.getInstance(guild).getGuildMusicManager().scheduler.nextTrack();
        return new ResponseEntity<>(new CommandResponseData(data.command, "Accepted"), HttpStatus.OK);
    }
}
