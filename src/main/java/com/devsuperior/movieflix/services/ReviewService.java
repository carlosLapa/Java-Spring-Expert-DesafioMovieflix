package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private AuthService authService;

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public ReviewDTO insert(ReviewDTO dto) {
        Review entity = new Review();
        entity.setText(dto.getText());
        entity.setMovie(movieRepository.getReferenceById(dto.getMovieId()));
        entity.setUser(authService.authenticated());
        entity = repository.save(entity);
        return new ReviewDTO(entity);
    }

}
