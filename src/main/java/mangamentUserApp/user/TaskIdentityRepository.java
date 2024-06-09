package mangamentUserApp.user;

import org.springframework.data.jpa.repository.JpaRepository;

interface TaskIdentityRepository extends JpaRepository<TaskIdentity, Long> {
}
