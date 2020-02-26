package sgsits.cse.dis.administration.serviceImpl;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import sgsits.cse.dis.administration.exception.ConflictException;
import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.feignClient.AcademicsClient;
import sgsits.cse.dis.administration.feignClient.UserClient;
import sgsits.cse.dis.administration.model.LibraryBookCategoryCount;
import sgsits.cse.dis.administration.model.LibraryBookRecords;
import sgsits.cse.dis.administration.model.LibraryCurrentIssues;
import sgsits.cse.dis.administration.model.LibraryIssueHistory;
import sgsits.cse.dis.administration.model.LibrarySettings;
import sgsits.cse.dis.administration.model.LibraryThesisRecords;
import sgsits.cse.dis.administration.repo.LibraryBookCategoryCountRepository;
import sgsits.cse.dis.administration.repo.LibraryBookRecordsRepository;
import sgsits.cse.dis.administration.repo.LibraryCurrentIssuesRepository;
import sgsits.cse.dis.administration.repo.LibraryIssueHistoryRepository;
import sgsits.cse.dis.administration.repo.LibrarySettingsRepository;
import sgsits.cse.dis.administration.repo.LibraryThesisRecordsRepository;
import sgsits.cse.dis.administration.request.AddBookForm;
import sgsits.cse.dis.administration.request.AddThesisForm;
import sgsits.cse.dis.administration.request.IssueForm;
import sgsits.cse.dis.administration.response.IssuedInformationResponse;
import sgsits.cse.dis.administration.service.LibraryServices;
import sgsits.cse.dis.administration.util.CalenderGeneralServices;

/**
 * <h1><b>LibraryServiceImpl</b> class.</h1>
 * <p>This class contains implementation of all the library services which are defined in the <b>LibraryService</b> interface.
 * 
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-DEC-2019.
 * @throws ConflictException.
 * @throws NotFoundException.
 * @throws EventDoesNotExistException.
 * @see NotFoundException.
 * @inheritDoc
 */
@Component
public class LibraryServicesImpl implements LibraryServices, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private LibraryBookRecordsRepository libraryBookRecordsRepository;

	@Autowired
	private LibraryBookCategoryCountRepository libraryBookCategoryCountRepository;

	@Autowired
	private LibraryThesisRecordsRepository libraryThesisRecordsRepository;

	@Autowired
	private LibrarySettingsRepository librarySettingsRepository;
	
	@Autowired
	private UserClient userClient;
	
	@Autowired 
	private LibraryCurrentIssuesRepository libraryCurrentIssuesRepository;
	
	@Autowired
	private LibraryIssueHistoryRepository libraryIssueHistoryRepository;
	
	@Autowired
	private AcademicsClient academicsClient;
	
	@Override
	public List<String> getSubjectCatergoryAcronymList() {
//		List<String> subjectAcronym = academicsClient.getAllSubjectAcronym();
//		List<String> other = libraryBookRecordsRepository.getDistinctSubjectCategory();
//		for(String temp : other) {
//			if(subjectAcronym.contains(temp) == false)
//				subjectAcronym.add(temp);
//		}
//		return subjectAcronym;
//		return libraryBookCategoryCountRepository.findAll();
		return libraryBookRecordsRepository.getDistinctSubjectCategory();
	}

	@Transactional
	@Override
	public String addBook(AddBookForm addBookForm) throws ConflictException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		LibraryBookRecords libraryBookRecord = new LibraryBookRecords();
		libraryBookRecord.setAuthorName(addBookForm.getAuthorName());
		libraryBookRecord.setIsbn(addBookForm.getIsbn());
		libraryBookRecord.setEdition(addBookForm.getEdition());
		libraryBookRecord.setEntryDate(simpleDateFormat.format(new Date()));
		libraryBookRecord.setNoOfPages(addBookForm.getNoOfPages());
		libraryBookRecord.setPrice(addBookForm.getPrice());
		libraryBookRecord.setPublisherAndPlace(addBookForm.getPublisherAndPlace());
		libraryBookRecord.setPurchaseDate(addBookForm.getPurchaseDate());
		libraryBookRecord.setRemarks(addBookForm.getRemarks());
		libraryBookRecord.setSubjectCategory(addBookForm.getSubjectCategory());
		libraryBookRecord.setTitle(addBookForm.getTitle());
		libraryBookRecord.setYearOfPublication(addBookForm.getYearOfPublication());
		String bookId = generateBookId(addBookForm.getSubjectCategory());
		libraryBookRecord.setBookId(bookId);
		LibraryBookRecords test = libraryBookRecordsRepository.save(libraryBookRecord);
		if (test.equals(null))
			throw new ConflictException("Book cannot be added. This is due to conflict in information on client side.");
		return bookId;
	}


	@Override
	public List<LibraryBookRecords> getAllBooks() {
		return libraryBookRecordsRepository.findAll();
	}


	@Override
	public List<LibraryBookRecords> getBookByTitle(String title) throws EventDoesNotExistException {
		List<LibraryBookRecords> libraryBookRecords;
		libraryBookRecords = libraryBookRecordsRepository.findByTitleContainingIgnoreCase(title);
		if (libraryBookRecords.isEmpty())
			throw new EventDoesNotExistException("Book with Title [" + title + "] doesn't exist.");
		return libraryBookRecords;
	}


	@Override
	public List<LibraryBookRecords> getBookByBookId(String bookId) throws EventDoesNotExistException {
		List<LibraryBookRecords> libraryBookRecords;
		libraryBookRecords = libraryBookRecordsRepository.findByBookIdIgnoreCase(bookId);
		if (libraryBookRecords.isEmpty())
			throw new EventDoesNotExistException("Book with book id [" + bookId + "] doesn't exist.");
		return libraryBookRecords;
	}

	@Override
	public List<LibraryBookRecords> getBookByAuthorName(String authorName) throws EventDoesNotExistException {
		List<LibraryBookRecords> libraryBookRecords;
		libraryBookRecords = libraryBookRecordsRepository.findByAuthorNameContainingIgnoreCase(authorName);
		if (libraryBookRecords.isEmpty())
			throw new EventDoesNotExistException("Book with author name [" + authorName + "] doesn't exist.");
		return libraryBookRecords;
	}

	/**
	 *  Helper function to generate book-id
	 * @param subjectCategory 
	 * @return bookId
	 */
	private String generateBookId(String subjectCategory) {
		LibraryBookCategoryCount libraryBookCategoryCount = new LibraryBookCategoryCount(subjectCategory);
			libraryBookCategoryCount = libraryBookCategoryCountRepository.findBySubjectCategory(subjectCategory).get(0);
			libraryBookCategoryCount.setCount(libraryBookCategoryCount.getCount() + 1);
		return libraryBookCategoryCount.getSubjectCategory() + "-" + libraryBookCategoryCount.getCount();
	}


	@Override
	public void updateBook(AddBookForm addBookForm, String bookId)
			throws EventDoesNotExistException, ConflictException {

		if (libraryBookRecordsRepository.existsByBookId(bookId)) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			LibraryBookRecords libraryBookRecord = new LibraryBookRecords();
			libraryBookRecord.setAuthorName(addBookForm.getAuthorName());
			libraryBookRecord.setIsbn(addBookForm.getIsbn());
			libraryBookRecord.setEdition(addBookForm.getEdition());
			libraryBookRecord.setEntryDate(simpleDateFormat.format(new Date()));
			libraryBookRecord.setNoOfPages(addBookForm.getNoOfPages());
			libraryBookRecord.setPrice(addBookForm.getPrice());
			libraryBookRecord.setPublisherAndPlace(addBookForm.getPublisherAndPlace());
			libraryBookRecord.setPurchaseDate(addBookForm.getPurchaseDate());
			libraryBookRecord.setRemarks(addBookForm.getRemarks());
			libraryBookRecord.setSubjectCategory(addBookForm.getSubjectCategory());
			libraryBookRecord.setTitle(addBookForm.getTitle());
			libraryBookRecord.setYearOfPublication(addBookForm.getYearOfPublication());
			libraryBookRecord.setBookId(bookId);
			LibraryBookRecords test = libraryBookRecordsRepository.save(libraryBookRecord);
			if (test.equals(null))
				throw new ConflictException("Book with book id [" + bookId + "] couldn't be updated.");
		} else
			throw new EventDoesNotExistException("Book with thesis id [" + bookId + "] not found.");

	}


	@Transactional
	@Override
	public void deleteBook(String bookId) throws EventDoesNotExistException, ConflictException {
		if (libraryBookRecordsRepository.existsByBookId(bookId)) {
			if (libraryBookRecordsRepository.deleteByBookId(bookId) <= 0)
				throw new ConflictException("Unable to delete book with book id: " + bookId + ".");
		} else
			throw new EventDoesNotExistException("Book with book id: " + bookId + " doesn't exist.");

	}

	// Thesis Services
	

	@Override
	public Long addThesis(AddThesisForm addThesisForm) throws ConflictException {

		LibraryThesisRecords test = libraryThesisRecordsRepository
				.save(new LibraryThesisRecords(addThesisForm.getYear(), addThesisForm.getSubmittedBy(),
						addThesisForm.getGuidedBy(), addThesisForm.getCdStatus(), addThesisForm.getCourse(),
						new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), addThesisForm.getTitle(),
						addThesisForm.getRemarks()));

		if (test.equals(null))
			throw new ConflictException("No records updated. This is due to conflict in information on client side.");

		return test.getThesisId();
	}


	@Override
	public List<LibraryThesisRecords> getAllThesis() {
		return libraryThesisRecordsRepository.findAll();
	}


	@Override
	public List<LibraryThesisRecords> getThesisByTitle(String title) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords;
		libraryThesisRecords = libraryThesisRecordsRepository.findByTitleContainingIgnoreCase(title);
		if (libraryThesisRecords.isEmpty())
			throw new EventDoesNotExistException("Thesis with title [" + title + "] doesn't exist.");
		return libraryThesisRecords;
	}


	@Override
	public List<LibraryThesisRecords> getThesisBySubmittedBy(String submittedBy) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords;
		libraryThesisRecords = libraryThesisRecordsRepository.findBySubmittedByContainingIgnoreCase(submittedBy);
		if (libraryThesisRecords.isEmpty())
			throw new EventDoesNotExistException("Thesis with submitted by [" + submittedBy + "] doesn't exist.");
		return libraryThesisRecords;
	}

	@Override
	public List<LibraryThesisRecords> getThesisByGuidedBy(String guidedBy) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords;
		libraryThesisRecords = libraryThesisRecordsRepository.findByGuidedByContainingIgnoreCase(guidedBy);
		if (libraryThesisRecords.isEmpty())
			throw new EventDoesNotExistException("Thesis with guided by [" + guidedBy + "] doesn't exist.");
		return libraryThesisRecords;
	}


	@Override
	public List<LibraryThesisRecords> getThesisByThesisId(long thesisId) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords;
		libraryThesisRecords = libraryThesisRecordsRepository.findByThesisId(thesisId);
		if (libraryThesisRecords.isEmpty())
			throw new EventDoesNotExistException("Thesis with thesis id [" + thesisId + "] doesn't exist.");
		return libraryThesisRecords;
	}


	@Override
	public List<LibraryThesisRecords> getThesisByCourse(String course) throws EventDoesNotExistException {
		List<LibraryThesisRecords> libraryThesisRecords;
		libraryThesisRecords = libraryThesisRecordsRepository.findByCourseContainingIgnoreCase(course);
		if (libraryThesisRecords.isEmpty())
			throw new EventDoesNotExistException("Thesis with course [" + course + "] doesn't exist.");
		return libraryThesisRecords;
	}


	@Override
	public void updateThesis(AddThesisForm addThesisForm, long thesisId)
			throws EventDoesNotExistException, ConflictException {
		if (libraryThesisRecordsRepository.existsByThesisId(thesisId)) {
			LibraryThesisRecords test = libraryThesisRecordsRepository
					.save(new LibraryThesisRecords(thesisId, addThesisForm.getYear(), addThesisForm.getSubmittedBy(),
							addThesisForm.getGuidedBy(), addThesisForm.getCdStatus(), addThesisForm.getCourse(),
							new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), addThesisForm.getTitle(),
							addThesisForm.getRemarks()));

			if (test.equals(null))
				throw new ConflictException("Thesis with thesis id [" + thesisId + "] couldn't be updated");

		} else
			throw new EventDoesNotExistException("Thesis with thesis id [" + thesisId + "] not found.");

	}


	@Transactional
	@Override
	public void deleteThesis(long thesisId) throws EventDoesNotExistException, ConflictException {
		if (libraryThesisRecordsRepository.existsByThesisId(thesisId)) {
			if (libraryThesisRecordsRepository.deleteByThesisId(thesisId) <= 0)
				throw new ConflictException("Unable to delete thesis with thesis id: " + thesisId + ".");
		} else
			throw new EventDoesNotExistException("Thesis with thesis id: " + thesisId + " doesn't exist.");
	}


	@Override
	public List<LibrarySettings> getSetting() {
		return librarySettingsRepository.findAll();

	}


	@Transactional
	@Override
	public void updateSettings(LibrarySettings librarySettings) throws EventDoesNotExistException {
		if (librarySettingsRepository.save(librarySettings).equals(null)) {
			throw new EventDoesNotExistException("Couldn't update the settings");
		}
	}


	@Transactional
	@Override
	public String issue(IssueForm issueForm) throws EventDoesNotExistException, ConflictException {
		String response;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(userClient.existsByUsername(issueForm.getUsername())){
			System.out.println(issueForm.getUsername());
			if(issueForm.getThesisId() != null) {
				response = "Failed to issue Thesis with id "+issueForm.getThesisId()
				+" to user "+issueForm.getUsername()+" This is because either the thesis is unavailable/issued or thesis id is wrong, please check on your end.";
				LibraryThesisRecords libraryThesisRecords = 
						libraryThesisRecordsRepository.findByThesisId(issueForm.getThesisId()).get(0);
				libraryThesisRecords.setStatus("Issued");
				libraryThesisRecordsRepository.save(libraryThesisRecords);
				LibraryCurrentIssues test = new LibraryCurrentIssues(issueForm.getUsername(),
						new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()),
						simpleDateFormat.format(CalenderGeneralServices.addDays(new Date(),
								Integer.parseInt(String.valueOf(getSetting().get(0).getReturnDeadlineDays())))),
						libraryThesisRecords.getTitle(),issueForm.getBookId(),issueForm.getThesisId());
				if(libraryCurrentIssuesRepository.save(test).equals(null)) {
					throw new ConflictException(response);
				}
				else {
					response = "Thesis id ["+issueForm.getThesisId()+
								"] Book name ["+libraryThesisRecords.getTitle()+
								"] Issued to ["+issueForm.getUsername()+"]";
				}
			}
			else{
				//issue book
				response = "Failed to issue book with id "+issueForm.getBookId()
				+" to user "+issueForm.getUsername()+" This is because either the book is unavailable/issued or book id is wrong, please check on your end.";
				LibraryBookRecords libraryBookRecords = 
						libraryBookRecordsRepository.findByBookIdIgnoreCase(issueForm.getBookId()).get(0);
				libraryBookRecords.setStatus("Issued");
				libraryBookRecordsRepository.save(libraryBookRecords);
				LibraryCurrentIssues test = new LibraryCurrentIssues(issueForm.getUsername(),
						simpleDateFormat.format(new Date()),
						simpleDateFormat.format(CalenderGeneralServices.addDays(new Date(),
								Integer.parseInt(String.valueOf(getSetting().get(0).getReturnDeadlineDays())))),
						libraryBookRecords.getTitle(),libraryBookRecords.getBookId(),issueForm.getThesisId());
				if(libraryCurrentIssuesRepository.save(test).equals(null)) {
					throw new ConflictException(response);
				}
				else {
					response = "Book id ["+issueForm.getBookId()+
								"] Book name ["+libraryBookRecords.getTitle()+
								"] Issued to ["+issueForm.getUsername()+"]";
				}
			}
		}
		//User not found
		else {
			throw new EventDoesNotExistException("username with "+issueForm.getUsername()+" not found.");
		}
		return response;
	}


	@Override
	public Long getNoOfIssues(String username) {
		return libraryCurrentIssuesRepository.findByUsernameIgnoreCase(username);
	}


	@Transactional
	@Override
	public String returnBook(String bookId) throws ParseException {
		List<LibraryCurrentIssues> libraryCurrentIssues = libraryCurrentIssuesRepository.findByBookId(bookId);
		//Transfer info to archive.
		try {
			LibraryIssueHistory test = new LibraryIssueHistory(libraryCurrentIssues.get(0).getUserName(), libraryCurrentIssues.get(0).getIssueDate(),
					libraryCurrentIssues.get(0).getExpectedReturnDate(),new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), 
					libraryCurrentIssues.get(0).getTitle(),bookId, libraryCurrentIssues.get(0).getThesisId(), 
					getPenalty(libraryCurrentIssues.get(0).getIssueDate()));
			libraryIssueHistoryRepository.save(test);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ParseException("Unable to get penality", 0);
		}
		//Change Book status to available.
		libraryBookRecordsRepository.updateStatus("Available", bookId);
		//Delete Current Issue
		if(libraryCurrentIssuesRepository.deleteByBookId(bookId) > 0)
			return new String("Return Successfull. Please make sure that penality amount(if any) has been collected");
		return new String("Return UnSuccessfull. Please try again later");
	}



	@Transactional
	@Override
	public String returnThesis(long thesisId) throws ParseException {
		System.out.println("Flag Start");
		List<LibraryCurrentIssues> libraryCurrentIssues = libraryCurrentIssuesRepository.findByThesisId(thesisId);
		//System.out.println("Flag 0");
		//Transfer info to archive.
		try {
			LibraryIssueHistory test = new LibraryIssueHistory(libraryCurrentIssues.get(0).getUserName(), libraryCurrentIssues.get(0).getIssueDate(),
					libraryCurrentIssues.get(0).getExpectedReturnDate(),new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), 
					libraryCurrentIssues.get(0).getTitle(),libraryCurrentIssues.get(0).getBookId(), thesisId, 
					getPenalty(libraryCurrentIssues.get(0).getIssueDate()));
			libraryIssueHistoryRepository.save(test);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ParseException("Unable to get penality", 0);
		}
		//System.out.println("Flag 1");
		//Change Book status to available.
		libraryThesisRecordsRepository.updateStatus("Available", thesisId);
		//Delete Current Issue
		//System.out.println("Flag 2");
		if(libraryCurrentIssuesRepository.deleteByThesisId(thesisId) > 0)
			return new String("Return Successfull. Please make sure that penality amount(if any) has been collected");
		return new String("Return UnSuccessfull. Please try again later");
	}


	@Override
	public IssuedInformationResponse getIssuedBookInfo(String bookId) throws EventDoesNotExistException, ParseException{
		List<LibraryCurrentIssues> libraryCurrentIssues = libraryCurrentIssuesRepository.findByBookId(bookId);
		if(libraryCurrentIssues.isEmpty()) {
			throw new EventDoesNotExistException("No current issue history for book with id ["+bookId+"]");
		}
		return new IssuedInformationResponse(libraryCurrentIssues.get(0).getUserName(), getPenalty(libraryCurrentIssues.get(0).getIssueDate()));
	}


	@Override
	public IssuedInformationResponse getIssuedThesisInfo(long thesisId) throws EventDoesNotExistException, ParseException {
		List<LibraryCurrentIssues> libraryCurrentIssues = libraryCurrentIssuesRepository.findByThesisId(thesisId);
		if(libraryCurrentIssues.isEmpty()) {
			throw new EventDoesNotExistException("No current issue history for thesis with id ["+thesisId+"]");
		}
		return new IssuedInformationResponse(libraryCurrentIssues.get(0).getUserName(), getPenalty(libraryCurrentIssues.get(0).getIssueDate()));
	}
	
	/**
	 * helper function to Calculate and return penalty.
	 * @param issueDate.
	 * @return penalty.
	 */
	long getPenalty(String issueDate) throws ParseException {
		long penalty = 0l;
		LibrarySettings librarySettings = getSetting().get(0);
		long daysIssued = CalenderGeneralServices.getDaysBetweenDates(issueDate,
				new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()).toString());
		System.out.println(daysIssued);
		if(daysIssued > librarySettings.getReturnDeadlineDays()) {
			daysIssued -=librarySettings.getReturnDeadlineDays();
			penalty = daysIssued * librarySettings.getPenaltyPerDay() ;
		}
		return penalty;
	}


	@Override
	public List<LibraryIssueHistory> getPreviousIssuesByUsername(String username) throws EventDoesNotExistException {
		List<LibraryIssueHistory> test = libraryIssueHistoryRepository.findByUsername(username);
		if (test.isEmpty())
			throw new EventDoesNotExistException("["+username+"] have no record of any books/thesis issued to them.");
		return test;
	}


	@Override
	public List<LibraryIssueHistory> getPreviousIssuesByBookId(String bookId) throws EventDoesNotExistException {
		List<LibraryIssueHistory> test = libraryIssueHistoryRepository.findByBookId(bookId);
		if (test.isEmpty())
			throw new EventDoesNotExistException("Book with id ["+bookId+"] has never been issued to any one.");
		return test;
	}

	
	@Override
	public List<LibraryIssueHistory> getPreviousIssuesByThesisId(Long thesisId) throws EventDoesNotExistException {
		List<LibraryIssueHistory> test = libraryIssueHistoryRepository.findByThesisId(thesisId);
		if (test.isEmpty())
			throw new EventDoesNotExistException("Thesis with id ["+thesisId+"] has never been issued to any one.");
		return test;
	}

	
	@Override
	public void addNewSubjectCategory(LibraryBookCategoryCount libraryBookCategoryCount) throws ConflictException {
		if(libraryBookCategoryCountRepository.existsBySubjectCategory(libraryBookCategoryCount.getSubjectCategory()))
			throw new ConflictException("Category id ["+libraryBookCategoryCount.getSubjectCategory()+"] already exists.");
		else {
			libraryBookCategoryCount.setCount(Long.valueOf(libraryBookRecordsRepository.
					findByBookIdContaining(libraryBookCategoryCount.getSubjectCategory()).size()));
			if(libraryBookCategoryCountRepository.save(libraryBookCategoryCount).equals(null))
				throw new ConflictException("Category cannot be added. This is due to conflict in information on client side.");	
		}
	}


	@Transactional
	@Override
	public void deleteSubjectCategory(String subjectCategory) throws EventDoesNotExistException{
		if(libraryBookCategoryCountRepository.existsBySubjectCategory(subjectCategory)) {
			if(libraryBookCategoryCountRepository.deleteBySubjectCategory(subjectCategory)<0)
				throw new EventDoesNotExistException("Category not found. Cannot delete.");
		}
		else
			throw new EventDoesNotExistException("Category id ["+subjectCategory+"] doesnt exists.");
	}


	@Override
	public List<LibraryBookCategoryCount> getSubjectNameByAcronym(String subjectCategory) throws EventDoesNotExistException {
		List<LibraryBookCategoryCount> libraryBookCategoryCounts = libraryBookCategoryCountRepository.findBySubjectCategoryContainingIgnoreCase(subjectCategory);
		if (libraryBookCategoryCounts.isEmpty())
			throw new EventDoesNotExistException("["+subjectCategory+"] does not exists");
		return libraryBookCategoryCounts;
	}


	@Override
	public List<LibraryBookCategoryCount> getAcronymBySubjectName(String subjectName) throws EventDoesNotExistException {
		List<LibraryBookCategoryCount> libraryBookCategoryCounts = libraryBookCategoryCountRepository.findBySubjectNameContainingIgnoreCase(subjectName);
		if (libraryBookCategoryCounts.isEmpty())
			throw new EventDoesNotExistException("["+subjectName+"] does not exists");
		return libraryBookCategoryCounts;
	}

}



