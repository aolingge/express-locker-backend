# Contributing

Thanks for improving `express-locker-backend`. This repository is a learning and portfolio backend, so the best contributions are small, reviewable, and easy to verify.

## Good Contributions

- Add redacted local configuration examples.
- Document database schema assumptions.
- Add controller, service, or mapper tests.
- Improve request validation and error messages.
- Tighten deployment examples around CORS, credentials, and runtime configuration.
- Improve the English or Chinese README while keeping both files aligned.

## Local Checks

Run the narrowest useful check before opening a pull request:

```bash
mvn test
```

For larger changes, also run:

```bash
mvn package
```

## Safety Rules

- Do not commit real database URLs, passwords, tokens, cookies, private paths, or private service endpoints.
- Keep example credentials fake and clearly marked.
- Prefer configuration placeholders over machine-specific values.
- Mention any required MySQL or Redis assumptions in the pull request.

## Pull Request Checklist

- [ ] The change is focused and easy to review.
- [ ] README files were updated when behavior or setup changed.
- [ ] `mvn test` passed or the reason it could not run is explained.
- [ ] No real secrets or private environment details were added.
