package nl.han.oose.dea.spotitube.controller.dto;

import java.util.List;

public class PlaylistsDTO {
    private List<PlaylistDTO> playlistDTOList;
    private long length;

    public PlaylistsDTO() {
    }

    public PlaylistsDTO(List<PlaylistDTO> playlistDTOList, long length) {
        this.playlistDTOList = playlistDTOList;
        this.length = length;
    }

    public List<PlaylistDTO> getPlaylistDTOList() {
        return playlistDTOList;
    }

    public void setPlaylistDTOList(List<PlaylistDTO> playlistDTOList) {
        this.playlistDTOList = playlistDTOList;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }
}
