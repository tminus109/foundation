# The Reddit

We'll create a simple reddit clone application, where the users can create posts
and upvote / downvote existing posts. Later on, you can extend this functionality.

## Mandatory functionality

- Listing posts from database in the presented format above.
- Adding new post via a simple form.
- Voting up and down posts via +/- links presented above.
- Persisting data in database, so restarting the application doesn't result in data loss.

## Extending functionality

- Make it cleaner:
    - In the controllers there shouldn't be any model-related logic, just calling methods.
    - The Post should have the ability to change it's score.
    - You can create a service which actually does the needed things with the repository,
      so in the controller methods just one service call remains.
    - Ask the mentors if it's clean enough :)
- Add a date to the posts and display it:
    - A constructor will be needed there at least.
- Always list the best 10 post (at first):
    - So you'll need to upgrade your repository.
    - And also handle pagination so the user can see the other posts.
- Make it pretty:
    - Wire in Bootstrap and make everything nicer.
- Add users:
    - Create a register page where a username and password can be given.
    - To enter the site, create a login page where only valid username-password
      combination is accepted.
    - After logging in, the user can create posts for oneself, so every post will have one owner.
        - User model will be needed.
        - Post model will be updated.
        - You'll need to somehow tell to your logic who is the current user
          and your endpoints must function only if there is a valid user in
          operation.
        - One user cannot vote up or down more than once, but can modify one's vote.
- Pro version: If you are interested in registration and keeping track of the
  users get to know the:
    - C#:
      [ASP.NET Identity](https://channel9.msdn.com/Series/Customizing-ASPNET-Authentication-with-Identity)
    - Java: try to follow [Dan Vega's](https://www.youtube.com/user/danvegadotorg)
      YouTube tutorials.
