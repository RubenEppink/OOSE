package nl.han.oose.dea.spotitube.domain;

import nl.han.oose.dea.spotitube.controller.dto.PlaylistDTO;
import nl.han.oose.dea.spotitube.controller.dto.PlaylistsDTO;
import nl.han.oose.dea.spotitube.controller.dto.TrackDTO;
import nl.han.oose.dea.spotitube.controller.exception.ItemNotAvailableException;
import nl.han.oose.dea.spotitube.datasource.DAO.PlaylistDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlaylistDomain {
    PlaylistDAO playlistDAO;
    List<PlaylistDTO> playlistDTOList = new ArrayList<>();


    public PlaylistDomain() {
        playlistDTOList.add(new PlaylistDTO(1, "test1", true));
        playlistDTOList.add(new PlaylistDTO(2, "test2", true));
        playlistDTOList.add(new PlaylistDTO(3, "test3", true));
        playlistDTOList.add(new PlaylistDTO(4, "test4", true));
        playlistDTOList.add(new PlaylistDTO(5, "test5", true));
    }

    public PlaylistDTO getPlaylist(int id) {
        Optional<PlaylistDTO> requestedPlaylist = playlistDTOList.stream().filter(playlist -> playlist.getId() == id).findFirst();

        if (requestedPlaylist.isPresent()) {
            return requestedPlaylist.get();
        } else {
            throw new ItemNotAvailableException();
        }
    }

    public PlaylistsDTO getPlaylistsDTO() {
        return new PlaylistsDTO(playlistDTOList, calculateDurationOfAllPlaylists());
    }

    private long calculateDurationOfAllPlaylists() {
        return playlistDTOList.stream()
                .mapToInt(this::calculateDurationOfPlaylist)
                .sum();
    }

    private int calculateDurationOfPlaylist(PlaylistDTO playlistDTO) {
        return playlistDTO.getTrackDTOList().stream().mapToInt(TrackDTO::getDuration).sum();
    }

    public PlaylistsDTO deletePlaylist(int id) {


        return getPlaylistsDTO();
    }
}
