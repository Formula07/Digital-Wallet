package org.kk.OnboardingService.respository;

import org.kk.OnboardingService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
