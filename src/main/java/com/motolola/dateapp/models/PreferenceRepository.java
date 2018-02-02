package com.motolola.dateapp.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("preferenceRepository")
public interface PreferenceRepository extends JpaRepository<Preference, Integer> {

}
