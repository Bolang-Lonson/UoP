def enrolled(d):
    '''Function to revert a dictionary of students and courses they're enrolled in and return another dictionary with each course as the key and a list of students enrolled to them as values'''
    courses = {}
    for stud in d:
        for course in d[stud]:
            if course not in courses:
                courses[course] = [stud]
            else:
                courses[course].append(stud)
    
    return courses

student_courses = {
    "Alice": ["CS101", "CS205", "CS340"],
    "Bob": ["CS101", "CS210", "CS355"],
    "Charlie": ["CS110", "CS240", "CS370"],
    "Diana": ["CS105", "CS225", "CS360"],
    "Eve": ["CS115", "CS250", "CS380"],
    "Fred": ["CS120", "CS230", "CS390"],
    "George": ["CS130", "CS260", "CS400"],
    "Helen": ["CS140", "CS270", "CS410"],
}

print(student_courses)
print('')
print(enrolled(student_courses))