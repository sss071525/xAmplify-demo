package com.xamplify.demo.modal;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "xa_user") // ✅ Explicitly maps to prefixed table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "UUID DEFAULT uuid_generate_v4()")
	private UUID id;

	@Column(nullable = false, unique = true, columnDefinition = "CITEXT")
	private String emailAddress;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Builder.Default
	private LocalDateTime createdAt = LocalDateTime.now(); // ✅ Maps to 'created_at'

	// ✅ Explicit Many-to-Many Mapping with UserCompany
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserCompany> userCompanies;

}
