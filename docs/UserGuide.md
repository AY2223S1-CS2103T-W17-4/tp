---
layout: page
title: User Guide
---

Are you a CS student struggling to keep track of your internship?
Do you feel tired of using spreadsheets to keep track of your applications?
We have just the right tool for you!

Introducing PleaseHireUs (PHU), the internship tracking application made just for you!

Here are its main features:
* View the status of your individual application and assessment dates at a glance
* View the overall statistics of the status of all your internship applications in a stacked bar chart

Now you will never miss any internship application deadlines or interviews again!
PleaseHireUs has been optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, PleaseHireUs can get your internship management tasks done faster than traditional GUI apps.
We hope you find PleaseHireUs to be very useful in your internship hunt!


* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `PleaseHireUs.jar` from [here](https://github.com/AY2223S1-CS2103T-W17-4/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your application.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all internships.

   * **`add n/Grab p/software engineer pr/ASSESSMENT web/https://www.grab.com/sg/about`** : Adds a new internship to the internship tracker.

   * **`delete 3`** : Deletes the 3rd internship shown in the current list.

   * **`clear`** : Deletes all internships.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------
## About this User Guide

This guides aims to:
1. Teach first-time users how to start using PleaseHireUs
2. Show and explain to users how to use each command
3. Provide users with a summary of the commands available
4. Provide advance users with tips to improve their experience


## Navigating the User Guide 
**Information Box**
<div markdown="block" class="alert alert-info">
**:information_source: Info:** Provides extra information that is useful
</div>

**Tip Box**
<div markdown="block" class="alert alert-success">
**:bulb: Tip:** Provides pointers to enhance your experience using the application 
</div>

**Warning Box**
<div markdown="block" class="alert alert-danger">
**:exclamation: Warning: Important messages**
</div>

**Highlights** <br>
`commands` or `PARAMETERS`

## Navigating the GUI

## Command Format
<div markdown="block" class="alert alert-info">
**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/COMPANY_NAME`, `COMPANY_NAME` is a parameter which can be used as `add n/Grab`.

* Items in square brackets are optional.<br>
  e.g `n/COMPANY_NAME [t/TAG]` can be used as `n/Jane Street t/highSalary` or as `n/Jane Street`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/highSalary`, `t/freeLunch t/transport` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/COMPANY_NAME pr/APPLICATION_PROCESS`, `pr/APPLICATION_PROCESS n/COMPANY_NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `n/Bytedance n/Tiktok`, only `n/Tiktok` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

## Features

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding an internship: `add`

Adds an internship into the list.

Format: `add n/COMPANY_NAME p/POSITION [pr/APPLICATION_PROCESS] [d/DATE] [ph/PHONE] [e/EMAIL] [web/WEBSITE] [r/REMARK]  [t/TAG]…​`

* Possible options for `APPLICATION_PROCESS` : `APPLY`, `ASSESSMENT`, `INTERVIEW`, `OFFER`, `ACCEPTED`, `REJECTED` 
* Case-insensitive: `Apply`, `APPLY`, and `apply` are all acceptable inputs.
* `APPLICATION_PROCESS` will be set to `APPLY` by default.
* `DATE` should be in dd-mm-yyyy format.
* `DATE` will be set to today’s date by default.
* `PHONE` will be set to "NA" by default.
* `EMAIL` will be set to "NA" by default.
* `WEBSITE` will be set to “NA” by default.
* `REMARK` will be empty by default.

<div markdown="block" class="alert alert-success">
**:bulb: Tip:** A person can have any number of tags (including 0)
</div>

Examples:
* `add n/Google ph/98765432 e/johnd@example.com r/Y2 summer break p/Backend Intern pr/APPLY d/11-12-2022 web/https://careers.google.com/jobs t/high t/java`
* `add n/Grab p/software engineer pr/ASSESSMENT web/https://www.grab.com/sg/about`
* `add n/Tiktok p/backend engineer`
* `add n/Shopee p/frontend engineer pr/INTERVIEW d/14-09-2022`

### Listing all internships : `list`

Shows a list of all internships. List of internships can be sorted by category in ascending or descending order.

Format: `list [c/CATEGORY [DESCENDING]]`

* List the internships 
* Internships can be sorted by category and in ascending or descending order
* The `CATEGORY` is optional. By default, without stating the category, `list` will display all internships in no particular order
  * Possible options for `CATEGORY` : `company_name`,`n`, `position`,`p`, `application_process`,`pr`, `date`,`d` (case-insensitive)
  * Case-insensitive: `company_name`, `Company_Name`, and `N` are all acceptable inputs.
* The `DESCENDING` tag is optional. It can take on the value `true` or `false` (case-insensitive). 
  * The DESCENDING tag is set to `false` by default if not stated. List of internships will be shown in ascending order.
  * The `DESCENDING` tag can only be set to `true` if the `CATEGORY` is stated
  * If `DESCENDING` is set to `true`. List of internships will be displayed in descending order

Examples:
* `list c/n true`
* `list c/date true`
* `list c/position false`

<div markdown="block" class="alert alert-info">
**:information_source: Info:** `DESCENDING` parameter will always default to `false` if the input is misspelt
</div>

### Locating internships by: `find`

Find internships whose data in the target category matched the given keyword/s.

Format: `find [c/CATEGORY] KEYWORDS…`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* The `CATEGORY` tag refers to company_name (or n), position (or p), application_process (or pr), tags (or t), date (or d) (case-insensitive)
* If not specified, the `CATEGORY` tag will be set to company_name as a default
* Only the target category is searched.
* A `KEYWORD` will match any string if the `KEYWORD` is contained in that string e.g. `Han` will match both `Reyhan` and `Handy`
* Internships whose target category match at least one keyword will be returned (i.e. OR search). e.g. `c/company_name Hans Bo` can return internships with company name of `Hans Gruber` or `Bo Yang`
* For the find by date category, all `KEYWORD` must be a valid date in `dd-mm-yyyy` format

Examples:
* `find c/p engineer` returns a list of internships with a position of Algorithm Engineer and Software Engineer
* `find sea shop` returns a list of internships with company name of Sea Labs, Shopee, and Shopback



### Deleting internship(s) : `delete`

Deletes the specified internship(s) from the list.

Format: `delete INDEX...`

* Deletes the internship at the specified `INDEX`.
* The index refers to the index number shown in the displayed internship list.
* The list use 1-based indexing, which means the index **must be a positive integer** such as 1, 2, 3, …
* Can add multiple `INDEX` to delete multiple internships.

Examples:
* `list` followed by `delete 1 3` deletes the 1st and 3rd internship from the list.
* `find TikTok` followed by `delete 1` deletes the 1st internship in the results of the `find` command.

### View details of an internship: `view`

View details of list item at index

Format: `view INDEX`

* Only the index is searched.
* The list use 1-based indexing, which means the index **must be a positive integer** such as 1, 2, 3, …
* More details about the company at the index will be displayed. 

Examples:
* `list` followed by `view 1` displays more details of the 1st internship in list.


### Editing internship : `edit`
Edit details of an internship

Format: `edit INDEX [n/COMPANY_NAME] [p/POSITION] [pr/APPLICATION_PROCESS] [d/ASSESSMENT_DATE] [ph/PHONE] [e/EMAIL] [r/REMARK] [web/WEBSITE] [t/TAG]...`

* Edit the details of internship at the specified `INDEX`.
* Similar to `delete`, the index here refers to the index number shown in the displayed internship list.

Examples:
* `list` followed by `edit 2 p/quant researcher d/01-01-2023` will edit the position and assignment date of the 1st internship in the list to quant researcher and 1 January 2023 respectively.
* `find hrt` followed by `edit 1 pr/REJECTED` will edit the application process of the 1st internship in the results of the find command to `REJECTED`.


### Clearing all entries : `clear`

Clears all entries from the internship tracker.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

PleaseHireUs data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

PleaseHireUs data are saved as a JSON file `[JAR file location]/data/internshipbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-danger">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.
</div>



### Archiving data files `[coming in v1.3]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous PleaseHireUs home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/COMPANY_NAME p/POSITION [pr/APPLICATION_PROCESS] [d/DATE] [ph/PHONE] [e/EMAIL] [web/WEBSITE] [r/REMARK]  [t/TAG]…​` <br> e.g., `add n/Tiktok p/backend engineer`
**Clear** | `clear`
**Delete** | `delete INDEX...`<br> e.g., `delete 1 3`
**View** | `view INDEX`<br> e.g., `view 1`
**Edit** | `edit INDEX [n/COMPANY_NAME] [p/POSITION] [pr/APPLICATION_PROCESS] [d/ASSESSMENT_DATE] [ph/PHONE] [e/EMAIL] [r/REMARK] [web/WEBSITE] [t/TAG]...​`<br> e.g.,`edit 2 p/Backend Intern pr/INTERVIEW d/01-11-2022`
**Find** | `find [c/CATEGORY] KEYWORDS...`<br> e.g., `find c/p engineer`
**List** | list [c/CATEGORY [DESCENDING]] <br> e.g, `list c/d true`
**Help** | `help`


## Acknowledgements
* This project is adapted from **[AddressBook 3(AB3)](https://github.com/se-edu/addressbook-level3)**
* Libraries used: [JavaFX](https://openjfx.io/), [Jackson](https://github.com/FasterXML/jackson), [JUnit5](https://github.com/junit-team/junit5)
* The PleaseHireUs icon is obtained from [flaticon](https://www.flaticon.com/free-icon/please_599536)
